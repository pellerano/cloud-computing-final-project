package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorJPA extends JpaRepository<Actor, Integer> {
    Actor findByName(String name);

    List<Actor> findByNameContainingIgnoreCase(String name);
}
