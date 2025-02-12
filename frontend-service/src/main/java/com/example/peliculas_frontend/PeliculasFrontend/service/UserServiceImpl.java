package com.example.peliculas_frontend.PeliculasFrontend.service;

import com.example.peliculas_frontend.PeliculasFrontend.dto.LoginResponse;
import com.example.peliculas_frontend.PeliculasFrontend.dto.RegisterRequest;
import com.example.peliculas_frontend.PeliculasFrontend.dto.RegisterResponse;
import com.example.peliculas_frontend.PeliculasFrontend.dto.UpdateRequest;
import com.example.peliculas_frontend.PeliculasFrontend.model.Actor;
import com.example.peliculas_frontend.PeliculasFrontend.model.User;
import com.example.peliculas_frontend.PeliculasFrontend.util.JwtUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    RestTemplate restTemplate = new RestTemplate();

    String url = "http://api-gateway:8080/api";

    @Override
    public List<User> getAllUsers() {
        String jwt = new JwtUtil().getJwtFromSecurityContext();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwt);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                url + "/user",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<User>>() {
                }).getBody();
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        List<User> userList = getAllUsers();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<User> list;

        assert userList != null;
        if (userList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, userList.size());
            list = userList.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), userList.size());
    }

    @Override
    public User findById(Integer userId) {
        String jwt = new JwtUtil().getJwtFromSecurityContext();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwt);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                url + "/user/" + userId,
                HttpMethod.GET,
                entity,
                User.class).getBody();
    }

    @Override
    public User findByEmail(String email) {
        String jwt = new JwtUtil().getJwtFromSecurityContext();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwt);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                url + "/user/email/" + email,
                HttpMethod.GET,
                entity,
                User.class).getBody();
    }

    @Override
    public void deleteUser(Integer id) {
        String jwt = new JwtUtil().getJwtFromSecurityContext();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwt);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        restTemplate.exchange(
                url + "/user/" + id,
                HttpMethod.DELETE,
                entity,
                Void.class);
    }

    @Override
    public LoginResponse login(String email, String password) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("email", email);
        map.add("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        return restTemplate.postForObject(url + "/auth/login", entity, LoginResponse.class);
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("email", registerRequest.getEmail());
        map.add("password", registerRequest.getPassword());
        map.add("confirmPassword", registerRequest.getConfirmPassword());
        map.add("name", registerRequest.getName());
        if (registerRequest.getRole() != null) {
            map.add("role", registerRequest.getRole().toString());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        return restTemplate.postForObject(url + "/auth/register", entity, RegisterResponse.class);
    }

    @Override
    public User save(UpdateRequest request, int id) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", request.getName());
        map.add("email", request.getEmail());
        if (request.getRole() != null) {
            map.add("role", request.getRole().toString());
        }

        String jwt = new JwtUtil().getJwtFromSecurityContext();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwt);

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        return restTemplate.postForObject(url + "/user/" + id, entity, User.class);
    }
}
