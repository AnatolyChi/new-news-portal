package com.newsportal.dao.impl;

import com.newsportal.dao.UserDAO;
import com.newsportal.entity.News;
import com.newsportal.entity.Role;
import com.newsportal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.*;

@Repository
public class UserDAOImpl implements UserDAO {

    public static final String NO_BCRIPT = "{noop}";

    @Autowired
    private SessionFactory sessionFactory;

//    @Autowired
//    private BCryptPasswordEncoder encoder;

    @Override
    public List<User> getListUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User ORDER BY id", User.class).list();
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        Role role = session.createQuery("FROM Role r WHERE roleName = :roleName", Role.class)
                .setParameter("roleName", "ROLE_USER")
                .getSingleResult();

        user.setPassword(NO_BCRIPT + user.getPassword());
        user.setUserRole(Collections.singleton(role));

        user.setEnabled(true);

        session.save(user);
    }

    @Override
    public Optional<User> getUser(int id) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public Optional<User> getUser(String login) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", login)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public Optional<User> getUser(String login, String password) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                .setParameter("username", login)
                .setParameter("password", password)
//                .setParameter("password", encoder.encode(password))
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public Set<News> getFavouriteNews(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.load(user, user.getId());
        Set<News> newsSet = user.getFavouriteNews();
        session.getTransaction().commit();
        return newsSet;
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession()
                .createQuery("UPDATE User u SET u.firstname = :firstname, u.lastname = :lastname, u.email = :email, u.age = :age")
                .setParameter("firstname", user.getFirstname())
                .setParameter("lastname", user.getLastname())
                .setParameter("email", user.getEmail())
                .setParameter("age", user.getAge())
                .executeUpdate();
    }
}
