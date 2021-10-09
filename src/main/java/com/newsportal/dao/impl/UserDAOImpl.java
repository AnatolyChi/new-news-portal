package com.newsportal.dao.impl;

import com.newsportal.dao.UserDAO;
import com.newsportal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<User> getListUsers() {
        return null;
    }

    @Override
    public void deleteUser(int id) {
        session = sessionFactory.getCurrentSession();
        session.delete(id);
    }

    @Override
    public void saveUser(User user) {
        session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public Optional<User> getUser(int id) {
        session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User u WHERE u.user_id = :id", User.class)
                .setParameter("id", id)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public Optional<User> getUser(String login) {
        session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User u WHERE u.login = :login", User.class)
                .setParameter("login", login)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public Optional<User> getUser(String login, String password) {
        session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User u WHERE u.login = :login AND u.password = :password", User.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .getResultList()
                .stream()
                .findFirst();
    }
}
