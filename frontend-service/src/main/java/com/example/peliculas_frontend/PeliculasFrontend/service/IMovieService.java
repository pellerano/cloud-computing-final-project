package com.example.peliculas_frontend.PeliculasFrontend.service;

import com.example.peliculas_frontend.PeliculasFrontend.model.Country;
import com.example.peliculas_frontend.PeliculasFrontend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovieService {
    Page<Movie> listMovies(Pageable pageable);

    List<Movie> listMovies();

    List<Country> listCountries();

    Movie getMovie(int id);

    void postComment(int movieId, int userId, String description, int score);

    void deleteComment(int commentId);

    void deleteMovie(int id);

}
