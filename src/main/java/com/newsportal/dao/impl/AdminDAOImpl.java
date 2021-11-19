package com.newsportal.dao.impl;

import com.newsportal.dao.AdminDAO;
import com.newsportal.entity.Role;
import com.newsportal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final String QUERY_FOR_GET_LIST_ROLES = "FROM Role";
    private static final String QUERY_FOR_GET_LIST_USERS = "FROM User ORDER BY id";


    @Override
    public void changeRole(User user) {
        Session session = sessionFactory.getCurrentSession();

        // Возможно стоит обрабатывать коллекцию в модели.

        Set<Role> currentRoles = session.createQuery(QUERY_FOR_GET_LIST_ROLES, Role.class).stream().collect(Collectors.toSet());
        Set<Role> roleSetUser = new HashSet<>();

        currentRoles.forEach(role -> user.getUserRole().stream()
                .filter(role1 -> role.getRoleName().equals(role1.getRoleName()))
                .map(role1 -> role).forEach(roleSetUser::add));

        session.load(user, user.getId());
        user.setUserRole(roleSetUser);

        session.persist(user);
    }

    @Override
    public List<User> getListUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY_FOR_GET_LIST_USERS, User.class).list();
    }

    @Override
    public List<Role> getListRoles() {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY_FOR_GET_LIST_ROLES, Role.class).list();
    }
}
