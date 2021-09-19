package com.newsportal.dao;

import com.newsportal.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getListUsers();
    void deleteUser(int id);
    void saveUser(User user);
    User getUser(int id);
}
