package com.newsportal.service.impl;

import com.newsportal.dao.NewsDAO;
import com.newsportal.entity.News;
import com.newsportal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void saveNews(News news) {

    }

    @Override
    @Transactional
    public void deleteNews(int id) {

    }

    @Override
    @Transactional
    public News getNews(int id) {
        return null;
    }
}
