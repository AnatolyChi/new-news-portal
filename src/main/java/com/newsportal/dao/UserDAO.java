package com.newsportal.dao;

import com.newsportal.entity.News;
import com.newsportal.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserDAO {
    List<User> getListUsers();
    void save(User user);
    void update(User user);
    Optional<User> getUser(int id);
    Optional<User> getUser(String login);
    Set<News> getFavouriteNews(User user);
}
