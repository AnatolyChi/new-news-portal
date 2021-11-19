package com.newsportal.controller;

import com.newsportal.entity.Role;
import com.newsportal.entity.User;
import com.newsportal.service.AdminService;
import com.newsportal.service.NewsService;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/news/control_panel")
public class AdminController {

    @Autowired
    private AdminService adminService;

    private static final String CONTROL_PANEL_PAGE = "control_panel";
    private static final String CONTROL_PANEL_REDIRECT = "redirect:/news/control_panel/";

    private static final String USERS_LIST_ATTRIBUTE = "usersList";
    private static final String ROLES_LIST_ATTRIBUTE = "rolesList";
    private static final String USER_MODEL_ATTRIBUTE = "userModel";

    @GetMapping("/")
    public String controlPanel(Model model) {
        List<User> users = adminService.getListUsers();
        List<Role> roles = adminService.getListRoles();

        model.addAttribute(USERS_LIST_ATTRIBUTE, users);
        model.addAttribute(ROLES_LIST_ATTRIBUTE, roles);
        model.addAttribute(USER_MODEL_ATTRIBUTE, new User());
        return CONTROL_PANEL_PAGE;
    }

    @PostMapping("/change_role")
    public String changeRole(@ModelAttribute User user) {
        adminService.changeRole(user);
        return CONTROL_PANEL_REDIRECT;
    }
}
