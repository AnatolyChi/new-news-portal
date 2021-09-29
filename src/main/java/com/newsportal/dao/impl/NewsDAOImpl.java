package com.newsportal.dao.impl;

import com.newsportal.dao.NewsDAO;
import com.newsportal.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<News> getListNews() {
        Session session = sessionFactory.getCurrentSession();
        Query<News> newsQuery = session.createQuery(
                "FROM News ORDER BY date", News.class);

        return newsQuery.getResultList();
    }

    @Override
    public void saveNews(News news) {

    }

    @Override
    public News getNews(int id) {
        return null;
    }

    @Override
    public void deleteNews(int id) {

    }
}
