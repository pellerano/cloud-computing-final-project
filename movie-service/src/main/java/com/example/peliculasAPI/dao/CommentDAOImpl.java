package com.example.peliculasAPI.dao;

import com.example.peliculasAPI.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements ICommentDAO{
    @Autowired
    ICommentJPA commentJPA;

    @Override
    public List<Comment> findAllByUserId(int userId) {
        return commentJPA.findAllByUserId(userId);
    }

    @Override
    public Comment save(Comment comment) {
        return commentJPA.save(comment);
    }

    @Override
    public void deleteById(Integer id) {
        commentJPA.deleteById(id);
    }
}
