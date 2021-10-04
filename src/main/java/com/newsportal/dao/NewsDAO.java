package com.newsportal.dao;

import com.newsportal.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsDAO {
    List<News> getListNews();
    void saveNews(News news);
    void updateNews(int newsId);
    void deleteNews(int id);
    News getNews(int id);
    Optional<News> getNews(String title);
    void updateNews(News news);
}
