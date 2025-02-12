package com.example.peliculas_frontend.PeliculasFrontend.service;

import com.example.peliculas_frontend.PeliculasFrontend.model.Comment;
import com.example.peliculas_frontend.PeliculasFrontend.model.Country;
import com.example.peliculas_frontend.PeliculasFrontend.model.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://api-gateway:8080/api";

    @Override
    public Page<Movie> listMovies(Pageable pageable) {
        ResponseEntity<List<Movie>> response = restTemplate.exchange(
                url + "/movies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Movie>>() {
                });

        List<Movie> moviesList = response.getBody();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Movie> list;

        assert moviesList != null;
        if (moviesList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, moviesList.size());
            list = moviesList.subList(startItem, toIndex);
        }
        Page<Movie> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), moviesList.size());

        return page;
    }

    @Override
    public List<Movie> listMovies() {
        // ResponseEntity<List<Movie>> response = restTemplate.exchange(
        // url + "/movies",
        // HttpMethod.GET,
        // null,
        // new ParameterizedTypeReference<List<Movie>>() {
        // }
        // );
        //
        // return response.getBody();
        return restTemplate.getForObject(url + "/movies", List.class);
    }

    @Override
    public List<Country> listCountries() {
        ResponseEntity<List<Country>> response = restTemplate.exchange(
                url + "/countries",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Country>>() {
                });
        return response.getBody();
    }

    @Override
    public Movie getMovie(int id) {
        ResponseEntity<Movie> response = restTemplate.exchange(
                url + "/movies/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Movie>() {
                });
        return response.getBody();
    }

    @Override
    public void postComment(int movieId, int userId, String comment, int score) {
        try {
            String requestUrl = UriComponentsBuilder.fromUriString(url + "/movies/{movieId}/comment")
                    .queryParam("userId", userId)
                    .queryParam("comment", comment)
                    .queryParam("score", score)
                    .buildAndExpand(movieId)
                    .toUriString();

            restTemplate.exchange(
                    requestUrl,
                    HttpMethod.POST,
                    null,
                    Void.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteComment(int commentId) {
        restTemplate.delete(url + "/movies/comment/" + commentId);
    }

    @Override
    public void deleteMovie(int id) {
        restTemplate.delete(url + "/movies/" + id);
    }
}
