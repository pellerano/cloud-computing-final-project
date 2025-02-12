package es.uah.peliculasAPIUsers.dao;

import es.uah.peliculasAPIUsers.model.Role;
import es.uah.peliculasAPIUsers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleJPA extends JpaRepository<Role, Integer> {
    Role findByName(String email);
}
