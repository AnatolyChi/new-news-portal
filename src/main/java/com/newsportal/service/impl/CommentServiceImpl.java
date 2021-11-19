package com.newsportal.service.impl;

import com.newsportal.dao.CommentDAO;
import com.newsportal.entity.Comment;
import com.newsportal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    @Transactional
    public void addComment(Comment comment) {
        commentDAO.addComment(comment);
    }

    @Override
    @Transactional
    public List<Comment> getCommentsByNews(int newsId) {
        return commentDAO.getCommentsByNews(newsId);
    }
}
