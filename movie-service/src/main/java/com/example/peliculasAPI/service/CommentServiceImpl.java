package com.example.peliculasAPI.service;

import com.example.peliculasAPI.dao.ICommentDAO;
import com.example.peliculasAPI.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService{

    @Autowired
    ICommentDAO commentDAO;

    @Override
    public List<Comment> findAllByUserId(int userId) {
        return commentDAO.findAllByUserId(userId);
    }

    @Override
    public Comment save(Comment comment) {
        return commentDAO.save(comment);
    }

    @Override
    public void deleteById(Integer id) {
        commentDAO.deleteById(id);
    }
}
