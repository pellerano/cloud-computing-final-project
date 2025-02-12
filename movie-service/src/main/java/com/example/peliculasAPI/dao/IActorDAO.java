package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Actor;

import java.util.List;

public interface IActorDAO {
    Actor findById(Integer id);

    List<Actor> findAll();

    Actor save(Actor actor);

    void deleteById(Integer id);

    Actor findByName(String name);

    List<Actor> findByNameContainingIgnoreCase(String name);
}
