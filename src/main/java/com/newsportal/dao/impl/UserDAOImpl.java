package com.newsportal.dao.impl;

import com.newsportal.dao.UserDAO;
import com.newsportal.entity.Role;
import com.newsportal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getListUsers() {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        // непонятно как сделать добавление по дефолту
        Role role = new Role();
        role.setId(2);
        user.setRole(role);

        session.save(user);
    }

    @Override
    public User getUser(int id) {
        return null;
    }
}
