package com.example.peliculasAPI.service;

import com.example.peliculasAPI.dao.IUserDAO;
import com.example.peliculasAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    IUserDAO userDAO;

    @Override
    public Optional<User> findById(Integer id) {
        return userDAO.findById(id);
    }
}
