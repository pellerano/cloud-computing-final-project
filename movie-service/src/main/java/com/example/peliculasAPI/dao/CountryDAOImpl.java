package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDAOImpl implements ICountryDAO{
    @Autowired
    ICountryJPA countryJPA;

    @Override
    public List<Country> findAll(){
        return countryJPA.findAll();
    }
}
