package com.newsportal.service.impl;

import com.newsportal.dao.AdminDAO;
import com.newsportal.entity.Role;
import com.newsportal.entity.User;
import com.newsportal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional
    public void changeRole(User user) {
        adminDAO.changeRole(user);
    }

    @Override
    @Transactional
    public List<User> getListUsers() {
        return adminDAO.getListUsers();
    }

    @Override
    @Transactional
    public List<Role> getListRoles() {
        return adminDAO.getListRoles();
    }
}
