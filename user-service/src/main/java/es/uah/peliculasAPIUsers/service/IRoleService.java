package es.uah.peliculasAPIUsers.service;

import es.uah.peliculasAPIUsers.model.Role;
import es.uah.peliculasAPIUsers.model.User;

import java.util.List;

public interface IRoleService {
    Role findById(Integer id);

    List<Role> findAll();

    Role save(Role role);

    void delete(Role role);

    Role findByName(String name);
}
