package com.example.peliculas_frontend.PeliculasFrontend.dto;

import com.example.peliculas_frontend.PeliculasFrontend.model.User;

public class LoginResult {
    private String accessToken;
    private User user;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
