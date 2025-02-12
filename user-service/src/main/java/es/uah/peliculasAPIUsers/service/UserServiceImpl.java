package es.uah.peliculasAPIUsers.service;

import es.uah.peliculasAPIUsers.dao.IUserDAO;
import es.uah.peliculasAPIUsers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    IUserDAO userDAO;

    public User findById(Integer id){
        return userDAO.findById(id);
    }

    public List<User> findAll(){
        return userDAO.findAll();
    };

    public User save(User user){
        return userDAO.save(user);
    };

    public void delete(User user){
        userDAO.delete(user);
    };

    public User findByEmail(String email){
        return userDAO.findByEmail(email);
    }
}
