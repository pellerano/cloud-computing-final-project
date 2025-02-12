package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Movie;

import java.util.List;

public interface IMovieDAO {
    Movie findById(Integer id);

    List<Movie> findAll();

    Movie save(Movie actor);

    void deleteById(Integer id);

    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByGenreContainingIgnoreCase(String title);

    List<Movie> findByActorsNameContainingIgnoreCase(String title);
}
