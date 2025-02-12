package com.example.peliculasAPI.controller;

import com.example.peliculasAPI.model.Comment;
import com.example.peliculasAPI.model.Movie;
import com.example.peliculasAPI.model.User;
import com.example.peliculasAPI.service.ICommentService;
import com.example.peliculasAPI.service.IMovieService;
import com.example.peliculasAPI.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    IMovieService movieService;

    @Autowired
    ICommentService commentService;

    @Autowired
    IUserService userService;

    String redirectUrl = "http://localhost:3000/movies";

    @PostMapping()
    public RedirectView createMovie(@ModelAttribute Movie movie) {
        movieService.save(movie);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrl);
        return redirectView;
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam(required = false) String title,
                                 @RequestParam(required = false) String genre,
                                 @RequestParam(required = false) String actorName) {
        return movieService.searchMovies(title, genre, actorName);
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Integer id) {
        return movieService.findById(id);
    }

    @PostMapping("/{id}")
    public RedirectView updateMovie(@PathVariable Integer id, @ModelAttribute Movie movie) {
        movie.setId(id);
        movieService.save(movie);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrl);
        return redirectView;
    }

    @PostMapping("/{id}/comment")
    public void addComment(@PathVariable Integer id, @RequestParam Integer userId, @RequestParam String comment, @RequestParam Integer score) {
        Movie movie = movieService.findById(id);
        Optional<User> user = userService.findById(userId);

        if(user.isPresent() && movie != null) {
            Comment newComment = new Comment();
            newComment.setDescription(comment);
            newComment.setMovie(movie);
            newComment.setUser(user.get());
            newComment.setScore(score);
            newComment.setDateCreated(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            commentService.save(newComment);
        }
    }

    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@PathVariable Integer commentId) {
        commentService.deleteById(commentId);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteById(id);
    }
}
