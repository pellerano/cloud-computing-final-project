package com.example.peliculasAPI.service;

import com.example.peliculasAPI.dao.ICountryDAO;
import com.example.peliculasAPI.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    ICountryDAO countryDAO;

    public List<Country> findAll() {
        return countryDAO.findAll();
    }
}
