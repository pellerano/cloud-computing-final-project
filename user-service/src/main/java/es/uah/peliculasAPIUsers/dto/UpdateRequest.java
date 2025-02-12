package es.uah.peliculasAPIUsers.dto;

import jakarta.validation.constraints.NotEmpty;

public class UpdateRequest {
    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    private Integer role;

    public @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotEmpty String name) {
        this.name = name;
    }

    public @NotEmpty String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
