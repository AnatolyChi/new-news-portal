package com.newsportal.service;

import com.newsportal.entity.News;

import java.util.List;

public interface NewsService {
    List<News> getListNews();
    void saveNews(News news);
    void deleteNews(int id);
    News getNews(int id);
}
