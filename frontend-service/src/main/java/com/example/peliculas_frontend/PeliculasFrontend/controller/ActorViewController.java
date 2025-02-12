package com.example.peliculas_frontend.PeliculasFrontend.controller;

import com.example.peliculas_frontend.PeliculasFrontend.model.Actor;
import com.example.peliculas_frontend.PeliculasFrontend.model.Country;
import com.example.peliculas_frontend.PeliculasFrontend.model.User;
import com.example.peliculas_frontend.PeliculasFrontend.paginator.PageRender;
import com.example.peliculas_frontend.PeliculasFrontend.service.IActorService;
import com.example.peliculas_frontend.PeliculasFrontend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/actors")
public class ActorViewController {
    RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "http://api-gateway:8080/api";

    @Autowired
    IActorService actorService;

    @Autowired
    IUserService userService;

    @GetMapping
    public String getActors(Model model, Principal principal,
            @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Actor> actors = actorService.listActors(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/actors", actors);

        List<Actor> actorList = actorService.listActors();
        model.addAttribute("actors", actorList);
        model.addAttribute("page", pageRender);
        if (principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }
        return "actors/list";
    }

    @GetMapping("/create")
    public String createActorForm(Model model, Principal principal) {
        ResponseEntity<List<Country>> response = restTemplate.exchange(
                baseUrl + "/countries",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Country>>() {
                });
        List<Country> countries = response.getBody();
        model.addAttribute("actor", new Actor());
        model.addAttribute("countries", countries);

        if (principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        return "actors/create";
    }

    @GetMapping("/edit/{id}")
    public String editActorForm(@PathVariable Integer id, Model model, Principal principal) {

        ResponseEntity<List<Country>> countriesResponse = restTemplate.exchange(
                baseUrl + "/countries",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        Actor actor = actorService.getActorById(id);
        List<Country> countries = countriesResponse.getBody();
        model.addAttribute("actor", actor);
        model.addAttribute("countries", countries);

        if (principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        return "actors/edit";
    }

    @GetMapping("/view/{id}")
    public String viewActor(@PathVariable Integer id, Model model, Principal principal) {

        ResponseEntity<List<Country>> countriesResponse = restTemplate.exchange(
                baseUrl + "/countries",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        Actor actor = actorService.getActorById(id);
        List<Country> countries = countriesResponse.getBody();
        model.addAttribute("actor", actor);
        model.addAttribute("countries", countries);

        if (principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }

        return "actors/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteActorForm(@PathVariable Integer id, Model model) {
        Actor actor = actorService.getActorById(id);
        if (actor != null) {
            actorService.deleteActor(id);
            model.addAttribute("msg", "Los datos del actor fueron borrados!");
        } else {
            model.addAttribute("msg", "Actor no encontrado!");
        }
        return "redirect:actors/list";
    }
}
