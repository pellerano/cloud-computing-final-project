package com.example.peliculasAPI.service;

import com.example.peliculasAPI.dao.IMovieDAO;
import com.example.peliculasAPI.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    IMovieDAO movieDAO;

    public Movie save(Movie movie) {
        return movieDAO.save(movie);
    }

    public List<Movie> findAll() {
        return movieDAO.findAll();
    }

    public Movie findById(Integer id) {
        return movieDAO.findById(id);
    }

    public void deleteById(Integer id) {
        movieDAO.deleteById(id);
    }

    public List<Movie> searchMovies(String title, String genre, String actorName) {
        if (title != null && !title.isEmpty()) {
            return movieDAO.findByTitleContainingIgnoreCase(title);
        } else if (genre != null && !genre.isEmpty()) {
            return movieDAO.findByGenreContainingIgnoreCase(genre);
        } else if (actorName != null && !actorName.isEmpty()) {
            return movieDAO.findByActorsNameContainingIgnoreCase(actorName);
        }
        return movieDAO.findAll();
    }
}
