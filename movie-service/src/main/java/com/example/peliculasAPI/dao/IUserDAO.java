package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.User;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> findById(Integer id);
}
