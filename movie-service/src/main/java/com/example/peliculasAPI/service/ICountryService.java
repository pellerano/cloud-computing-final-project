package com.example.peliculasAPI.service;

import com.example.peliculasAPI.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> findAll();
}
