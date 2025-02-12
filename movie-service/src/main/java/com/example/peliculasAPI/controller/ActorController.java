package com.example.peliculasAPI.controller;

import com.example.peliculasAPI.model.Actor;
import com.example.peliculasAPI.service.IActorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    String redirectUrl = "http://localhost:3000/actors";

    @Autowired
    IActorService actorService;

    @PostMapping
    public RedirectView createActor(@ModelAttribute Actor actor) {
        actorService.save(actor);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrl);
        return redirectView;
    }

    @GetMapping
    public List<Actor> getActors() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor getActor(@PathVariable Integer id) {
        Actor actor = actorService.findById(id);
        return actor;
    }

    @PostMapping("/{id}")
    public RedirectView updateActor(@PathVariable Integer id, @ModelAttribute @Valid Actor actor) {
        actor.setId(id);
        actorService.save(actor);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrl);
        return redirectView;
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Integer id) {
        actorService.deleteById(id);
    }
}
