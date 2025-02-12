package com.example.peliculas_frontend.PeliculasFrontend.service;

import com.example.peliculas_frontend.PeliculasFrontend.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IActorService {
    Page<Actor> listActors(Pageable pageable);

    List<Actor> listActors();

    Actor getActorById(int id);

    void deleteActor(int id);
}
