package com.newsportal.dao.impl;

import com.newsportal.dao.NewsDAO;
import com.newsportal.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<News> getListNews() {
        Session session = sessionFactory.getCurrentSession();
        Query<News> newsQuery = session.createQuery(
                "FROM News ORDER BY date", News.class);

        return newsQuery.getResultList();
    }

    @Override
    public List<News> getListNews(int page) {
        session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM News ORDER BY id", News.class)
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
    public void updateNews(int newsId) {
        session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(session.get(News.class, newsId));
    }

    @Override
    public News getNews(int id) {
        session = sessionFactory.getCurrentSession();
        return session.get(News.class, id);
    }

    @Override
    public Optional<News> getNews(String title) {
        session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM News n WHERE n.title = :title", News.class)
                .setParameter("title", title)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void updateNews(News news) {
        session = sessionFactory.getCurrentSession();
        session.createQuery("UPDATE News n SET n.title = :title, n.content = :content WHERE n.id = :id")
                .setParameter("title", news.getTitle())
                .setParameter("content", news.getContent())
                .setParameter("id", news.getId())
                .executeUpdate();
    }

    @Override
    public int countNews() {
        session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT COUNT(*) FROM News", Number.class)
                .getSingleResult()
                .intValue();
    }

    @Override
    public void deleteNews(int id) {
        session = sessionFactory.getCurrentSession();
        session.delete(session.get(News.class, id));
    }
}
