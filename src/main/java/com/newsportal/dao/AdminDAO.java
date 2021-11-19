package com.newsportal.dao;

import com.newsportal.entity.Role;
import com.newsportal.entity.User;

import java.util.List;

public interface AdminDAO {
    void changeRole(User user);
    List<User> getListUsers();
    List<Role> getListRoles();
}
