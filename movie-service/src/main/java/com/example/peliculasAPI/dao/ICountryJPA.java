package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryJPA extends JpaRepository<Country, Integer> {
}
