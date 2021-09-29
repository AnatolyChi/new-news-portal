package com.newsportal.controller;

import com.newsportal.entity.User;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
@RequestMapping("/news/user")
public class UserController {

    @Autowired
    private UserService userService;

    // cannot use
    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }

    @GetMapping("/sign_up")
    public String initSignUp(User user, Model model) {
//        User user = new User();
        model.addAttribute("user", user);
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String createSignUp(User user) {
        userService.saveUser(user);
        // попробовать через уникальное значение выбросить исключение
        return "redirect:/news/main";
    }

    @GetMapping("/log_in")
    public String initLogIn(User user, Model model) {
//        User user = new User();
        model.addAttribute("user", user);
        return "log_in";
    }

    @PostMapping("/log_in")
    public String createLogIn(@ModelAttribute("user") User user, Model model) {
        // проверку на нал сделать, то есть взятие юзера
        model.addAttribute("user", userService.getUser(user.getId()));
        return "redirect:/news/main";
    }

    @GetMapping("log_out")
    public String destroyUser(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/news";
    }
}
