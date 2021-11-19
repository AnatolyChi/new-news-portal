package com.newsportal.service.impl;

import com.newsportal.dao.UserDAO;
import com.newsportal.entity.News;
import com.newsportal.entity.User;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public boolean saveUser(User user) {
        Optional<User> userFromDB = userDAO.getUserByLogin(user.getUsername());

        if (userFromDB.isPresent()) {
            return false;
        }

        userDAO.save(user);
        return true;
    }

    @Override
    @Transactional
    public Optional<User> getUser(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public Optional<User> getUser(String login) {
        return userDAO.getUserByLogin(login);
    }

    @Override
    @Transactional
    public Set<News> getFavouriteNews(User user) {
        return userDAO.getFavouriteNews(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDAO.getUserByLogin(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("error");
        }

        return user.get();
    }
}
