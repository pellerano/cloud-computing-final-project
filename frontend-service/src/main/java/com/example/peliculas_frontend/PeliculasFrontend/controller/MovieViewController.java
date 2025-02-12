package com.example.peliculas_frontend.PeliculasFrontend.controller;

import com.example.peliculas_frontend.PeliculasFrontend.model.*;
import com.example.peliculas_frontend.PeliculasFrontend.paginator.PageRender;
import com.example.peliculas_frontend.PeliculasFrontend.service.IActorService;
import com.example.peliculas_frontend.PeliculasFrontend.service.IMovieService;
import com.example.peliculas_frontend.PeliculasFrontend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieViewController {

    @Autowired
    IMovieService movieService;

    @Autowired
    IUserService userService;

    @Autowired
    IActorService actorService;

    @GetMapping
    public String getMovies(Model model, Principal principal, @RequestParam(name="page", defaultValue="0") int page) {

        Pageable pageable = PageRequest.of(page, 5);
        Page<Movie> movies = movieService.listMovies(pageable);
        PageRender<Movie> pageRender = new PageRender<Movie>("/movies", movies);
        model.addAttribute("movies", movies);
        model.addAttribute("page", pageRender);
        if(principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }
        return "movies/list";
    }

    @GetMapping("/create")
    public String createMovieForm(Model model, Principal principal) {
        List<Country> countries = movieService.listCountries();
        model.addAttribute("countries", countries);

        if(principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        return "movies/create";
    }

    @GetMapping("/edit/{id}")
    public String editMovieForm(@PathVariable Integer id, Model model, Principal principal) {

        Movie movie = movieService.getMovie(id);
        List<Country> countries = movieService.listCountries();

        model.addAttribute("movie", movie);
        model.addAttribute("countries", countries);

        if(principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        return "movies/edit";
    }

    @GetMapping("/view/{id}")
    public String viewMovie(@PathVariable Integer id, Model model, Principal principal) {
        Movie movie = movieService.getMovie(id);
        model.addAttribute("movie", movie);

        if(movie.getComments() == null || movie.getComments().isEmpty()) {
            model.addAttribute("score", "TBD");
        } else{
            double score = 0;
            for (Comment comment : movie.getComments()) {
                score += comment.getScore();
            }
            double value = score/movie.getComments().size();
            BigDecimal bd = BigDecimal.valueOf(value);
            bd = bd.setScale(1, RoundingMode.CEILING);
            model.addAttribute("score", bd.doubleValue());
        }

        if(principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        return "movies/view";
    }

    @GetMapping("/edit/{id}/actors")
    public String editMovieActorsForm(@PathVariable Integer id, Model model, Principal principal) {
        Movie movie = movieService.getMovie(id);
        List<Actor> actors = actorService.listActors();
        model.addAttribute("actors", actors);
        model.addAttribute("movie", movie);

        if(principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        return "movies/edit_actors";
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteMovie(@PathVariable Integer id, Model model, Principal principal){
        Movie movie = movieService.getMovie(id);
        if (movie != null) {
            movieService.deleteMovie(id);
            model.addAttribute("msg", "Los datos de la matricula fueron borrados!");
        } else {
            model.addAttribute("msg", "Alumno no encontrado!");
        }
        if(principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }
        return new RedirectView("/movies");
    }

    @PostMapping("/{id}/comment")
    public String postComment(@PathVariable Integer id, Model model, Principal principal, @ModelAttribute Comment comment) {
        User user = userService.findByEmail(principal.getName());
        movieService.postComment(id, user.getId(), comment.getDescription(), comment.getScore());
        return "redirect:/movies/view/" + id;
    }
}

