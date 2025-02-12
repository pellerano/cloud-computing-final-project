package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJPA extends JpaRepository<User, Integer> {
}
