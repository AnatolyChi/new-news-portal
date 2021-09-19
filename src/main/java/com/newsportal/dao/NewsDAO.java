package com.newsportal.dao;

import com.newsportal.entity.News;

import java.util.List;

public interface NewsDAO {
    List<News> getListNews();
    void saveNews(News news);
    void deleteNews(int id);
    News getNews(int id);
}
