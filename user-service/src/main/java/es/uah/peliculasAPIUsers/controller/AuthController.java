package es.uah.peliculasAPIUsers.controller;

import es.uah.peliculasAPIUsers.dto.*;
import es.uah.peliculasAPIUsers.model.Role;
import es.uah.peliculasAPIUsers.model.User;
import es.uah.peliculasAPIUsers.security.JwtIssuer;
import es.uah.peliculasAPIUsers.service.IRoleService;
import es.uah.peliculasAPIUsers.service.IUserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtIssuer jwtIssuer;

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@ModelAttribute RegisterRequest request) {

        RegisterResponse response = new RegisterResponse();
        List<String> currentErrors = new ArrayList<>();
        User existingUser = userService.findByEmail(request.getEmail());

        if(!request.getPassword().equals(request.getConfirmPassword())) {
            currentErrors.add("La contraseña y la contraseña de confirmación no coinciden");
        }

        if(existingUser != null) {
            currentErrors.add("El usuario ya existe");
        }

        if(!currentErrors.isEmpty()) {
            response.setErrors(currentErrors);
            response.setSuccess(Boolean.FALSE);
            return ResponseEntity.ok().body(response);
        }

        try{
            User newUser = new User();
            var bCryptEncoder = new BCryptPasswordEncoder();

            newUser.setName(request.getName());
            newUser.setEmail(request.getEmail());
            newUser.setPassword(bCryptEncoder.encode(request.getPassword()));

            List<Role> roles = new ArrayList<>();

            Role role = roleService.findById((request.getRole() != null) ? request.getRole() : 2);
            roles.add(role);
            newUser.setRoles(roles);


            User createdUser = userService.save(newUser);
            response.setSuccess(createdUser != null);
            response.setResult(newUser);
        }catch(Exception e) {
            currentErrors.add(e.getMessage());
            response.setErrors(currentErrors);
            response.setSuccess(Boolean.FALSE);
            return ResponseEntity.ok().body(response);
        }

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@ModelAttribute @Valid LoginRequest request, HttpServletResponse response) throws IOException {

        User user = userService.findByEmail(request.getEmail());

        LoginResponse res = new LoginResponse();
        List<String> currentErrors = new ArrayList<>();

        var bCryptEncoder = new BCryptPasswordEncoder();

        if(user == null){
            currentErrors.add("El usuario no existe");
            res.setErrors(currentErrors);
            res.setSuccess(Boolean.FALSE);

            return ResponseEntity.ok().body(res);
        }

        if(bCryptEncoder.matches(request.getPassword(), user.getPassword())) {
            res.setSuccess(true);
            var token = jwtIssuer.issue(1, request.getEmail(), user.getRoles());
            LoginResult result = new LoginResult(token);
            result.setUser(user);
            res.setResult(result);

            response.addHeader("Authorization", "Bearer " + token);
            response.addCookie(new Cookie("jwtToken", token));
            return ResponseEntity.ok().body(res);
        }else{
            res.setSuccess(false);
            currentErrors.add("Contraseña incorrecta");
            res.setErrors(currentErrors);
            return ResponseEntity.ok().body(res);
        }
    }
}
