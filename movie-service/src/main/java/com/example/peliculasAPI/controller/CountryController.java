package com.example.peliculasAPI.controller;

import com.example.peliculasAPI.model.Country;
import com.example.peliculasAPI.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    ICountryService countryService;

    @GetMapping
    public List<Country> getCountries() {
        return countryService.findAll();
    }
}
