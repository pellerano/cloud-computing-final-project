package es.uah.peliculasAPIUsers.dao;

import es.uah.peliculasAPIUsers.model.Role;

import java.util.List;

public interface IRoleDAO {
    Role findById(Integer id);

    List<Role> findAll();

    Role save(Role role);

    void delete(Role role);

    Role findByName(String name);
}
