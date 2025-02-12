package com.example.peliculas_frontend.PeliculasFrontend.controller;

import com.example.peliculas_frontend.PeliculasFrontend.dto.RegisterRequest;
import com.example.peliculas_frontend.PeliculasFrontend.dto.RegisterResponse;
import com.example.peliculas_frontend.PeliculasFrontend.dto.UpdateRequest;
import com.example.peliculas_frontend.PeliculasFrontend.model.Actor;
import com.example.peliculas_frontend.PeliculasFrontend.model.User;
import com.example.peliculas_frontend.PeliculasFrontend.paginator.PageRender;
import com.example.peliculas_frontend.PeliculasFrontend.service.IMovieService;
import com.example.peliculas_frontend.PeliculasFrontend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminViewController {
    @Autowired
    IUserService userService;

    @Autowired
    IMovieService movieService;

    @GetMapping
    public String index(Model model, Principal principal, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<User> users = userService.getAllUsers(pageable);
        PageRender<User> pageRender = new PageRender<User>("/admin", users);

        List<User> usersList = userService.getAllUsers();
        model.addAttribute("users", usersList);
        model.addAttribute("page", pageRender);
        if(principal != null) {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("user", user);
        }
        return "admin/index";
    }

    @GetMapping("/user/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "admin/create_user";
    }

    @PostMapping("/user/create")
    public String create(@ModelAttribute RegisterRequest request, Model model) {
        RegisterResponse res = userService.register(request);
        model.addAttribute("errors", res.getErrors());
        model.addAttribute("registerSuccessful", res.getSuccess());
        return "redirect:/admin";
    }

    @PostMapping("/user/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute UpdateRequest request) {
        userService.save(request, id);
        return "redirect:/admin";
    }

    @GetMapping("/user/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "admin/view_user";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        if (user != null) {
            userService.deleteUser(id);
            model.addAttribute("msg", "Los datos del usuario fueron borrados!");
        } else {
            model.addAttribute("msg", "Usuario no encontrado!");
        }
        return "redirect:/admin";
    }

    @GetMapping("/user/{userId}/comment/delete/{commentId}")
    public String deleteComment(@PathVariable Integer userId, @PathVariable Integer commentId, Model model) {
        User user = userService.findById(userId);
        if (user != null) {
            movieService.deleteComment(commentId);
            model.addAttribute("user", user);
            return "redirect:/admin/user/view/" + userId;
        }
        return "redirect:/admin" + userId;
    };
}
