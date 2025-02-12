package com.example.peliculas_frontend.PeliculasFrontend.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtUtil {

    public String getJwtFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            Object token = authentication.getDetails();
            if (token instanceof String) {
                return (String) token;
            }
        }
        return null;
    }
}
