package com.newsportal.service;

import com.newsportal.entity.Comment;
import com.newsportal.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    List<News> getListNews();
    List<News> getListNews(int page);
    Optional<News> getNews(String title);
    void saveNews(News news);
    void updateNews(int newsId);
    void deleteNews(int id);
    News getNews(int id);
    void updateNews(News news);
    int newsCount();
    boolean addToFavourite(int userId, int newsId);
    boolean deleteFromFavourite(int userId, int newsId);
    void addComment(Comment comment);
}
