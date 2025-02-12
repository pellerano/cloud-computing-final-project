package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentJPA extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByUserId(int userId);
}
