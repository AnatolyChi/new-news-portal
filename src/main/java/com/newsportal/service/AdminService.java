package com.newsportal.service;

import com.newsportal.entity.Role;
import com.newsportal.entity.User;

import java.util.List;

public interface AdminService {
    void changeRole(User user);
    List<User> getListUsers();
    List<Role> getListRoles();
}
