package es.uah.peliculasAPIUsers.dao;

import es.uah.peliculasAPIUsers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements  IUserDAO {

    @Autowired
    IUserJPA userJPA;

    @Override
    public User findById(Integer id){
        Optional<User> user = userJPA.findById(id);
        return user.orElse(null);
    }

    public List<User> findAll(){
        return userJPA.findAll();
    };

    public User save(User user){
        return userJPA.save(user);
    };

    public void delete(User user){
        userJPA.delete(user);
    };

    public User findByEmail(String email){
        return userJPA.findByEmail(email);
    }
}
