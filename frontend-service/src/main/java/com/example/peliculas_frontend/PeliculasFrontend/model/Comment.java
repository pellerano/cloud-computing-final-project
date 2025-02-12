package com.example.peliculas_frontend.PeliculasFrontend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

public class Comment {
    private Integer id;
    private String description;
    private LocalDate date_created;
    private Integer score;

    @JsonIgnoreProperties("comments")
    private User user;

    @JsonIgnoreProperties("comments")
    private Movie movie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getDateCreated() {
        return date_created;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.date_created = dateCreated;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
