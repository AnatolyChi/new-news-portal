package com.newsportal.dao;

import com.newsportal.entity.Comment;

import java.util.List;

public interface CommentDAO {
    void addComment(Comment comment);
    List<Comment> getCommentsByNews(int newsId);
}
