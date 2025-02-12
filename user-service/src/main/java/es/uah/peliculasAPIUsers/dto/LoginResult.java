package es.uah.peliculasAPIUsers.dto;

import es.uah.peliculasAPIUsers.model.User;

public class LoginResult {
    private final String accessToken;

    private User user;

    public LoginResult(String accessToken) {
        this.accessToken = accessToken;
    }

    public final String getAccessToken() {
        return accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
