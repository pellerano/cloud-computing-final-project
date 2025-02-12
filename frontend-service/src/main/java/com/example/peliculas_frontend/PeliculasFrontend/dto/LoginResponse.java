package com.example.peliculas_frontend.PeliculasFrontend.dto;

import java.util.List;

public class LoginResponse {
    private boolean success;
    private List<String> errors;
    private LoginResult result;

    // Getters and setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public LoginResult getResult() {
        return result;
    }

    public void setResult(LoginResult result) {
        this.result = result;
    }
}
