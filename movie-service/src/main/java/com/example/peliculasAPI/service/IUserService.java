package com.example.peliculasAPI.service;

import com.example.peliculasAPI.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findById(Integer id);
}
