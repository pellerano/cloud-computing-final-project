package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAOImpl implements IUserDAO{
    @Autowired
    IUserJPA userJPA;

    @Override
    public Optional<User> findById(Integer id) {
        return userJPA.findById(id);
    }
}
