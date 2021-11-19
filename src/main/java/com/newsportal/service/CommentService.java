package com.newsportal.service;

import com.newsportal.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getCommentsByNews(int newsId);
}
