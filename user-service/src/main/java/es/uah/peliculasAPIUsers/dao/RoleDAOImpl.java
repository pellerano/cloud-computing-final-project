package es.uah.peliculasAPIUsers.dao;

import es.uah.peliculasAPIUsers.model.Role;
import es.uah.peliculasAPIUsers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleDAOImpl implements IRoleDAO{
    @Autowired
    IRoleJPA roleJPA;

    @Override
    public Role findById(Integer id){
        Optional<Role> role = roleJPA.findById(id);
        return role.orElse(null);
    }

    public List<Role> findAll(){
        return roleJPA.findAll();
    };

    public Role save(Role role){
        return roleJPA.save(role);
    };

    public void delete(Role role){
        roleJPA.delete(role);
    };

    public Role findByName(String name){
        return roleJPA.findByName(name);
    }
}
