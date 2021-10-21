package com.newsportal.service.impl;

import com.newsportal.dao.UserDAO;
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
    public List<User> getListUsers() {
        return null;
    }

    @Override
    @Transactional
    public boolean saveUser(User user) {
        Optional<User> userFromDB = userDAO.getUser(user.getUsername());

        if (userFromDB.isPresent()) {
            return false;
        }

        userDAO.saveUser(user);
        return true;
    }

    @Override
    @Transactional
    public Optional<User> getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public Optional<User> getUser(String login) {
        return userDAO.getUser(login);
    }

    @Override
    @Transactional
    public Optional<User> getUser(String login, String password) {
        return userDAO.getUser(login, password);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDAO.getUser(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("error");
        }

        return user.get();
    }
}
