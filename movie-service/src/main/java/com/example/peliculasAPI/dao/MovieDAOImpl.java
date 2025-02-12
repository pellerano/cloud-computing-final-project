package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDAOImpl implements IMovieDAO{
    @Autowired
    IMovieJPA movieJPA;

    @Override
    public Movie findById(Integer id){
        Optional<Movie> optional = movieJPA.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Movie> findAll(){
        return movieJPA.findAll();
    }

    @Override
    public Movie save(Movie movie){
        return movieJPA.save(movie);
    }

    @Override
    public void deleteById(Integer id){
        movieJPA.deleteById(id);
    }
    @Override
    public List<Movie> findByTitleContainingIgnoreCase(String title){
        return movieJPA.findByTitleContainingIgnoreCase(title);
    };

    @Override
    public List<Movie> findByGenreContainingIgnoreCase(String genre){
        return movieJPA.findByGenreContainingIgnoreCase(genre);
    };

    @Override
    public List<Movie> findByActorsNameContainingIgnoreCase(String actorName){
        return movieJPA.findByActorsNameContainingIgnoreCase(actorName);
    };
}
