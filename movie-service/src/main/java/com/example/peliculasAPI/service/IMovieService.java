package com.example.peliculasAPI.service;

import com.example.peliculasAPI.model.Movie;

import java.util.List;

public interface IMovieService {
    Movie findById(Integer id);

    List<Movie> findAll();

    Movie save(Movie actor);

    void deleteById(Integer id);

    List<Movie> searchMovies(String title, String genre, String actorName);
}
