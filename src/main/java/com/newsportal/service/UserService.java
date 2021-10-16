package com.newsportal.service;

import com.newsportal.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getListUsers();
    boolean saveUser(User user);
    Optional<User> getUser(int id);
    Optional<User> getUser(String login);
    Optional<User> getUser(String login, String password);
}
