package es.uah.peliculasAPIUsers.service;

import es.uah.peliculasAPIUsers.model.User;

import java.util.List;

public interface IUserService {
    User findById(Integer id);

    List<User> findAll();

    User save(User user);

    void delete(User user);

    User findByEmail(String email);
}
