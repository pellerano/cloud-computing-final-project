package com.example.peliculasAPI.service;

import com.example.peliculasAPI.dao.IActorDAO;
import com.example.peliculasAPI.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    IActorDAO actorDAO;

    public Actor findById(Integer id){
        return actorDAO.findById(id);
    };

    public List<Actor> findAll(){
        return actorDAO.findAll();
    };

    public Actor save(Actor actor){
        return actorDAO.save(actor);
    };

    public void deleteById(Integer id){
        actorDAO.deleteById(id);
    };

    public Actor findByName(String name){
        return actorDAO.findByName(name);
    };

    public List<Actor> findByNameContainingIgnoreCase(String name){
        return actorDAO.findByNameContainingIgnoreCase(name);
    }
}
