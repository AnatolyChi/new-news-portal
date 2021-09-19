package com.newsportal.service;

import com.newsportal.entity.User;

import java.util.List;

public interface UserService {
    List<User> getListUsers();
    void deleteUser(int id);
    void saveUser(User user);
    User getUser(int id);
}
