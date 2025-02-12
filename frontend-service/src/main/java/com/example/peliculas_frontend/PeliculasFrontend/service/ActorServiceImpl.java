package com.example.peliculas_frontend.PeliculasFrontend.service;

import com.example.peliculas_frontend.PeliculasFrontend.model.Actor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://api-gateway:8080/api";

    @Override
    public Page<Actor> listActors(Pageable pageable) {
        ResponseEntity<List<Actor>> response = restTemplate.exchange(
                url + "/actors",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        List<Actor> actorList = response.getBody();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Actor> list;

        assert actorList != null;
        if (actorList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, actorList.size());
            list = actorList.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), actorList.size());
    }

    @Override
    public List<Actor> listActors() {
        ResponseEntity<List<Actor>> response = restTemplate.exchange(
                url + "/actors",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    @Override
    public Actor getActorById(int id) {
        ResponseEntity<Actor> response = restTemplate.exchange(
                url + "/actors/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    @Override
    public void deleteActor(int id) {
        restTemplate.delete(url + "/actors/" + id);
    }
}
