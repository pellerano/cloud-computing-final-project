package com.example.peliculas_frontend.PeliculasFrontend.security;

import com.example.peliculas_frontend.PeliculasFrontend.dto.LoginResponse;
import com.example.peliculas_frontend.PeliculasFrontend.dto.LoginResult;
import com.example.peliculas_frontend.PeliculasFrontend.model.Role;
import com.example.peliculas_frontend.PeliculasFrontend.model.User;
import com.example.peliculas_frontend.PeliculasFrontend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUserService userService;

    public CustomAuthenticationProvider() {
        super();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        LoginResponse response = userService.login(email, password);

        boolean success = response.isSuccess();

        if(success) {
            LoginResult result = response.getResult();
            User user = result.getUser();
            String accessToken = result.getAccessToken();

            if (user != null) {
                final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
                for (Role role : user.getRoles()) {
                    grantedAuths.add(new SimpleGrantedAuthority(role.getName()));
                }
                final UserDetails principal = new org.springframework.security.core.userdetails.User(email, password, grantedAuths);

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email, password, grantedAuths);

                SecurityContextHolder.getContext().setAuthentication(auth);

                auth.setDetails(accessToken);

                return auth;
            }
            return null;
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
