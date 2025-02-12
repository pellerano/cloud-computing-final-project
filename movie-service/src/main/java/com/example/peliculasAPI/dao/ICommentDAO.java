package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Comment;

import java.util.List;

public interface ICommentDAO {
    List<Comment> findAllByUserId(int userId);

    Comment save(Comment comment);

    void deleteById(Integer id);
}
