package com.newsportal.service.impl;

import com.newsportal.dao.UserDAO;
import com.newsportal.entity.User;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getListUsers() {
        return null;
    }

    @Override
    @Transactional
    public void deleteUser(int id) {

    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }
}
