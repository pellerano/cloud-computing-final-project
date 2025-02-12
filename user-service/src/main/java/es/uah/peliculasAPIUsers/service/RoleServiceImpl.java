package es.uah.peliculasAPIUsers.service;

import es.uah.peliculasAPIUsers.dao.IRoleDAO;
import es.uah.peliculasAPIUsers.model.Role;
import es.uah.peliculasAPIUsers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    IRoleDAO roleDAO;

    public Role findById(Integer id){
        return roleDAO.findById(id);
    }

    public List<Role> findAll(){
        return roleDAO.findAll();
    };

    public Role save(Role role){
        return roleDAO.save(role);
    };

    public void delete(Role role){
        roleDAO.delete(role);
    };

    public Role findByName(String email){
        return roleDAO.findByName(email);
    }

}
