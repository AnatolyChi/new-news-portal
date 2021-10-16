package com.newsportal.dao;

import com.newsportal.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getListUsers();
    void saveUser(User user);
    Optional<User> getUser(int id);
    Optional<User> getUser(String login);
    Optional<User> getUser(String login, String password);
}
