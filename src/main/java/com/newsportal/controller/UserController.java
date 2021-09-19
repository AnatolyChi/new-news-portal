package com.newsportal.controller;

import com.newsportal.entity.User;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/sign_up")
    public String initSignUp(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String createSignUp(@ModelAttribute("user") User user) {
        System.err.println(user);
        userService.saveUser(user);
        return "redirect:/news/main";
    }

    @GetMapping("/log_in")
    public String initLogIn(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "log_in";
    }
}
