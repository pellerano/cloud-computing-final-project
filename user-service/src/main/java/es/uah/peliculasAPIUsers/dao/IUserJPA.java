package es.uah.peliculasAPIUsers.dao;

import es.uah.peliculasAPIUsers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJPA extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
