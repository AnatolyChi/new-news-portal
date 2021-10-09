package com.newsportal.service.impl;

import com.newsportal.dao.NewsDAO;
import com.newsportal.entity.News;
import com.newsportal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    @Transactional
    public List<News> getListNews() {
        return newsDAO.getListNews();
    }

    @Override
    @Transactional
    public List<News> getListNews(int page) {
        return newsDAO.getListNews(page);
    }

    @Override
    @Transactional
    public void saveNews(News news) {
        newsDAO.saveNews(news);
    }

    @Override
    @Transactional
    public void updateNews(int newsId) {
        newsDAO.updateNews(newsId);
    }

    @Override
    @Transactional
    public void deleteNews(int id) {
        newsDAO.deleteNews(id);
    }

    @Override
    @Transactional
    public News getNews(int id) {
        return newsDAO.getNews(id);
    }

    @Override
    @Transactional
    public Optional<News> getNews(String title) {
        return newsDAO.getNews(title);
    }

    @Override
    @Transactional
    public void updateNews(News news) {
        newsDAO.updateNews(news);
    }

    @Override
    @Transactional
    public int newsCount() {
        return newsDAO.countNews();
    }
}
