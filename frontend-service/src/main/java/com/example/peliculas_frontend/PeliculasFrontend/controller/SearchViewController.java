package com.example.peliculas_frontend.PeliculasFrontend.controller;

import com.example.peliculas_frontend.PeliculasFrontend.model.User;
import com.example.peliculas_frontend.PeliculasFrontend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/search")
public class SearchViewController {

    @Autowired
    IUserService userService;

    @GetMapping
    public String searchMovies(Model model, Principal principal) {

        if(principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        return "search/index";
    }
}
