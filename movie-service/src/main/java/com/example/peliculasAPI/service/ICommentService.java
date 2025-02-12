package com.example.peliculasAPI.service;

import com.example.peliculasAPI.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAllByUserId(int userId);

    Comment save(Comment comment);

    void deleteById(Integer id);
}
