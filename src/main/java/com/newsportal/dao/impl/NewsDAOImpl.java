package com.newsportal.dao.impl;

import com.newsportal.dao.NewsDAO;
import com.newsportal.entity.Comment;
import com.newsportal.entity.News;
import com.newsportal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class NewsDAOImpl implements NewsDAO {

    private static final String QUERY_FOR_COUNT_NEWS = "SELECT COUNT(*) FROM News";
    private static final String QUERY_FOR_GET_LIST_NEWS_BY_PAGE = "FROM News ORDER BY id";
    private static final String QUERY_FOR_GET_NEWS_BY_TITLE = "FROM News n WHERE n.title = :title";

    private static final String TITLE_PARAM = "title";

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<News> getListNews(int page) {
        session = sessionFactory.getCurrentSession();
        return session.createQuery(QUERY_FOR_GET_LIST_NEWS_BY_PAGE, News.class)
                .setFirstResult(6 * (page - 1))
                .setMaxResults(6)
                .getResultList();
    }

    @Override
    public void saveNews(News news) {
        session = sessionFactory.getCurrentSession();
        session.save(news);
    }

    @Override
    public News getNews(int id) {
        session = sessionFactory.getCurrentSession();
        return session.get(News.class, id);
    }

    @Override
    public Optional<News> getNews(String title) {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY_FOR_GET_NEWS_BY_TITLE, News.class)
                .setParameter(TITLE_PARAM, title)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void updateNews(News news) {
        sessionFactory.getCurrentSession().update(news);
    }

    @Override
    public int countNews() {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY_FOR_COUNT_NEWS, Number.class)
                .getSingleResult()
                .intValue();
    }

    @Override
    public boolean addToFavourite(int userId, int newsId) {
        session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, userId);
        News news = session.load(News.class, newsId);
        Set<News> newsSet = user.getFavouriteNews();
        return newsSet.add(news);
    }

    @Override
    public boolean deleteFromFavourite(int userId, int newsId) {
        session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, userId);
        News news = session.load(News.class, newsId);
        Set<News> newsSet = user.getFavouriteNews();
        return newsSet.remove(news);
    }

    @Override
    public void deleteNews(int id) {
        session = sessionFactory.getCurrentSession();
        session.delete(session.get(News.class, id));
    }
}
