package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Country;

import java.util.List;

public interface ICountryDAO {
    List<Country> findAll();
}
