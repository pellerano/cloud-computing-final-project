package com.example.peliculas_frontend.PeliculasFrontend.service;

import com.example.peliculas_frontend.PeliculasFrontend.dto.LoginResponse;
import com.example.peliculas_frontend.PeliculasFrontend.dto.RegisterRequest;
import com.example.peliculas_frontend.PeliculasFrontend.dto.RegisterResponse;
import com.example.peliculas_frontend.PeliculasFrontend.dto.UpdateRequest;
import com.example.peliculas_frontend.PeliculasFrontend.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    Page<User> getAllUsers(Pageable pageable);

    User findById(Integer userId);

    User findByEmail(String email);

    void deleteUser(Integer id);

    LoginResponse login(String email, String password);

    RegisterResponse register(RegisterRequest registerRequest);

    User save(UpdateRequest request, int id);
}
