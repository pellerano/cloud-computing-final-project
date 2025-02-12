package com.example.peliculas_frontend.PeliculasFrontend.controller;

import com.example.peliculas_frontend.PeliculasFrontend.model.Movie;
import com.example.peliculas_frontend.PeliculasFrontend.model.User;
import com.example.peliculas_frontend.PeliculasFrontend.service.IMovieService;
import com.example.peliculas_frontend.PeliculasFrontend.service.IUserService;
import com.example.peliculas_frontend.PeliculasFrontend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeViewController {

    @Autowired
    IMovieService movieService;

    @Autowired
    IUserService userService;

    @GetMapping("/")
    public String home(Model model, Principal principal) {

        if(principal != null) {
            String jwt = new JwtUtil().getJwtFromSecurityContext();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + jwt);

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        List<Movie> movies = movieService.listMovies().stream().limit(5).toList();
        model.addAttribute("movies", movies);
        return "index";
    }
}