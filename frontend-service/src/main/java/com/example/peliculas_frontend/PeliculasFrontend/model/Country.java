package com.example.peliculas_frontend.PeliculasFrontend.model;

import java.util.HashSet;
import java.util.Set;

public class Country {

    private Integer id;
    private String name;
    private Set<Actor> actors = new HashSet<>();
    private Set<Movie> movies = new HashSet<>();

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
