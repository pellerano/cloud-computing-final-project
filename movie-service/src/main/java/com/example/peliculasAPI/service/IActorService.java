package com.example.peliculasAPI.service;

import com.example.peliculasAPI.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IActorService {
    Actor findById(Integer id);

    List<Actor> findAll();

    Actor save(Actor actor);

    void deleteById(Integer id);

    Actor findByName(String name);

    List<Actor> findByNameContainingIgnoreCase(String name);
}
