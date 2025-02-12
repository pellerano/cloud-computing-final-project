package com.example.peliculas_frontend.PeliculasFrontend.dto;

public class UpdateRequest {
        private String name;

        private String email;

        private Integer role;

        public String getName() {
            return name;
        }

        public void setName( String name) {
            this.name = name;
        }

        public  String getEmail() {
            return email;
        }

        public void setEmail( String email) {
            this.email = email;
        }

        public Integer getRole() {
            return role;
        }

        public void setRole(Integer role) {
            this.role = role;
        }
}
