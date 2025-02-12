package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorDAOImpl implements IActorDAO{
    @Autowired
    IActorJPA actorJPA;

    @Override
    public Actor findById(Integer id){
        Optional<Actor> optional = actorJPA.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Actor> findAll(){
        return actorJPA.findAll();
    }

    @Override
    public Actor save(Actor actor){
        return actorJPA.save(actor);
    }

    @Override
    public void deleteById(Integer id){
        actorJPA.deleteById(id);
    }

    @Override
    public Actor findByName(String name){
        return actorJPA.findByName(name);
    }

    @Override
    public List<Actor> findByNameContainingIgnoreCase(String name) {
        return actorJPA.findByNameContainingIgnoreCase(name);
    }
}
