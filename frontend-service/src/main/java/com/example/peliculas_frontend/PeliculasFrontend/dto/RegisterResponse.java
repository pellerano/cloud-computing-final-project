package com.example.peliculas_frontend.PeliculasFrontend.dto;

import com.example.peliculas_frontend.PeliculasFrontend.model.User;

import java.util.List;

public class RegisterResponse {
    private Boolean success;
    private List<String> errors;
    private User result;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public User getResult() {
        return result;
    }

    public void setResult(User result) {
        this.result = result;
    }
}
