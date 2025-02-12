package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieJPA extends JpaRepository<Movie, Integer> {
    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByGenreContainingIgnoreCase(String genre);

    List<Movie> findByActorsNameContainingIgnoreCase(String actorName);
}
