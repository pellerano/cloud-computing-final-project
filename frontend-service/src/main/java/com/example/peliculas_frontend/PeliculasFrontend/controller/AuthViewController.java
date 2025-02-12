package com.example.peliculas_frontend.PeliculasFrontend.controller;

import com.example.peliculas_frontend.PeliculasFrontend.dto.RegisterRequest;
import com.example.peliculas_frontend.PeliculasFrontend.dto.RegisterResponse;
import com.example.peliculas_frontend.PeliculasFrontend.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class AuthViewController {

    @Autowired
    IUserService userService;

    @GetMapping("/login")
    public String login(Model model, Principal principal, @RequestParam(value = "error", required = false) String error) {
        if (principal != null) return "redirect:/";
        if (error != null) {
            model.addAttribute("error",
                    "Error al iniciar sesión: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
        }
        return "auth/login";
    }
    
    @GetMapping("/register")
    public String register(Model model, Principal principal) {
        if (principal != null) return "redirect:/";
        return "auth/register";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @PostMapping("/register")
    public String signup(@ModelAttribute RegisterRequest request, Model model){
        RegisterResponse response = userService.register(request);
        model.addAttribute("errors", response.getErrors());
        model.addAttribute("registerSuccessful", response.getSuccess());
        if(!response.getSuccess()) return "auth/register";
        return "redirect:/";
    }
}