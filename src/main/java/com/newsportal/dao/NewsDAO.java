package com.newsportal.dao;

import com.newsportal.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsDAO {
    List<News> getListNews();
    List<News> getListNews(int page);
    Optional<News> getNews(String title);
    News getNews(int id);
    int countNews();
    void saveNews(News news);
    void updateNews(int newsId);
    void deleteNews(int id);
    void updateNews(News news);
    boolean addToFavourite(int userId, int newsId);
    boolean deleteFromFavourite(int userId, int newsId);
}
