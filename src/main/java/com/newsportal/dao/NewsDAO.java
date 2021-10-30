package com.newsportal.dao;

import com.newsportal.entity.Comment;
import com.newsportal.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsDAO {
    Optional<News> getNews(String title);
    List<News> getListNews(int page);
    List<News> getListNews();
    News getNews(int id);
    int countNews();
    void saveNews(News news);
    void deleteNews(int id);
    void updateNews(News news);
    void addComment(Comment comment);
    boolean addToFavourite(int userId, int newsId);
    boolean deleteFromFavourite(int userId, int newsId);
    List<Comment> getCommentsByNews(int newsId);
}
