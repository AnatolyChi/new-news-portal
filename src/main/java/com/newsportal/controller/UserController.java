package com.newsportal.controller;

import com.newsportal.entity.User;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/news/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/sign_up")
    public String initSignUp(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String createSignUp(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "sign_up";
        } else if (userService.getUser(user.getLogin()).isEmpty()) {
            userService.saveUser(user);
            httpSession.setAttribute("user", user);
            return "redirect:/news/main";
        }

        // сообщение о существовании введенного логина
        return "sign_up";
    }

    @GetMapping("/log_in")
    public String initLogIn(Model model) {
        model.addAttribute("user", new User());
        return "log_in";
    }

    @PostMapping("/log_in")
    public String createLogIn(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "log_in";
        } else if (userService.getUser(user.getLogin(), user.getPassword()).isPresent()) {
            httpSession.setAttribute("user", user);
            return "redirect:/news/main";
        }

        // сообщение о неверности логина или пароля
        return "log_in";
    }

    @GetMapping("/log_out")
    public String destroyUser() {
        httpSession.invalidate();
        return "redirect:/news/main";
    }

    @GetMapping("/own_page")
    public String ownPage() {
        return "own_page";
    }
}
