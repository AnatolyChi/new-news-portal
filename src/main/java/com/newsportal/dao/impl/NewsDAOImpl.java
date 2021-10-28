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

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        return sessionFactory.getCurrentSession()
                .createQuery("FROM News n WHERE n.title = :title", News.class)
                .setParameter("title", title)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void updateNews(News news) {
        sessionFactory.getCurrentSession()
                .createQuery("UPDATE News n SET n.title = :title, n.content = :content WHERE n.id = :id")
                .setParameter("title", news.getTitle())
                .setParameter("content", news.getContent())
                .setParameter("id", news.getId())
                .executeUpdate();
    }

    @Override
    public int countNews() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM News", Number.class)
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
    public void addComment(Comment comment) {
        session = sessionFactory.getCurrentSession();
        session.save(comment);
    }

    @Override
    public void deleteNews(int id) {
        session = sessionFactory.getCurrentSession();
        session.delete(session.get(News.class, id));
    }
}
