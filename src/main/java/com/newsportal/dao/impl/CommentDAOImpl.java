package com.newsportal.dao.impl;

import com.newsportal.dao.CommentDAO;
import com.newsportal.entity.Comment;
import com.newsportal.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<Comment> getCommentsByNews(int newsId) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        News news = session.load(News.class, newsId);
        List<Comment> comments = news.getComments();
        comments.sort(Comparator.comparing(Comment::getDate));

        session.getTransaction().commit();
        return comments;
    }

    @Override
    public void addComment(Comment comment) {
        session = sessionFactory.getCurrentSession();
        session.save(comment);
    }
}
