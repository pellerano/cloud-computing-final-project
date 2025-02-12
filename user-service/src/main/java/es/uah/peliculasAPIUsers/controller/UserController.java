package es.uah.peliculasAPIUsers.controller;

import es.uah.peliculasAPIUsers.dto.UpdateRequest;
import es.uah.peliculasAPIUsers.model.Role;
import es.uah.peliculasAPIUsers.model.User;
import es.uah.peliculasAPIUsers.service.IRoleService;
import es.uah.peliculasAPIUsers.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @GetMapping
    public List<User> listUsers() {
        return userService.findAll();
    }

    @GetMapping("/email/{email}")
    public User searchUser(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/{id}")
    public User searchUser(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PostMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @ModelAttribute UpdateRequest request) {
        User currentUser = userService.findById(id);
        currentUser.setName(request.getName());
        currentUser.setEmail(request.getEmail());

        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findById(request.getRole()));
        currentUser.setRoles(roles);

        return userService.save(currentUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        User user = userService.findById(id);
        userService.delete(user);
    }
}
