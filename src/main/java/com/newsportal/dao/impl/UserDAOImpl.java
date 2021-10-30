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

    private static final String QUERY_FOR_GET_LIST_USERS = "FROM User ORDER BY id";
    private static final String QUERY_FOR_SAVE_USER = "FROM Role r WHERE roleName = :roleName";
    private static final String QUERY_FOR_GET_USER_BY_ID ="FROM User u WHERE u.id = :id";
    private static final String QUERY_FOR_GET_USER_BY_USERNAME = "FROM User u WHERE u.username = :username";

    private static final String ROLE_PARAM = "roleName";
    private static final String ROLE_DEFAULT = "ROLE_USER";
    private static final String ID_PARAM = "id";
    private static final String USERNAME_PARAM = "username";

    public static final String NO_BCRIPT = "{noop}";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getListUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY_FOR_GET_LIST_USERS, User.class).list();
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();

        Role role = session.createQuery(QUERY_FOR_SAVE_USER, Role.class)
                .setParameter(ROLE_PARAM, ROLE_DEFAULT)
                .getSingleResult();

        user.setPassword(NO_BCRIPT + user.getPassword());
        user.setUserRole(Collections.singleton(role));
        user.setEnabled(true);

        session.save(user);
    }

    @Override
    public Optional<User> getUser(int id) {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY_FOR_GET_USER_BY_ID, User.class)
                .setParameter(ID_PARAM, id)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public Optional<User> getUser(String login) {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY_FOR_GET_USER_BY_USERNAME, User.class)
                .setParameter(USERNAME_PARAM, login)
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
        sessionFactory.getCurrentSession().update(user);
    }
}
