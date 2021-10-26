package com.newsportal.controller;

import com.newsportal.entity.News;
import com.newsportal.entity.User;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Set;

@Controller
@RequestMapping("/news/user")
public class UserController {

    private static final String OWN_PAGE = "own_page";
    private static final String USER_FORM_PAGE = "user_form";
    private static final String FAVOURITE_NEWS_PAGE = "favourite_news";

    private static final String USER_ATTRIBUTE = "user";
    private static final String FAVOURITE_NEWS_ATTRIBUTE = "favouriteNewsList";
    private static final String REDIRECT_OWN_PAGE = "redirect:/news/user/own_page";

    @Autowired
    private UserService userService;

    private User getUser(Principal principal) {
        return userService.getUser(principal.getName()).get();
    }

    @GetMapping("/own_page")
    public String ownPage(Principal principal, Model model) {
        model.addAttribute(USER_ATTRIBUTE, getUser(principal));
        return OWN_PAGE;
    }

    @GetMapping("/favourite_news")
    public String favouriteNews(Principal principal, Model model) {
        Set<News> newsList = userService.getFavouriteNews(getUser(principal));
        model.addAttribute(FAVOURITE_NEWS_ATTRIBUTE, newsList);
        return FAVOURITE_NEWS_PAGE;
    }

    @GetMapping("/update_own_page")
    public String updateOwnPage(Principal principal, Model model) {
        model.addAttribute(USER_ATTRIBUTE, getUser(principal));
        return USER_FORM_PAGE;
    }

    @PostMapping("/update_own_page")
    public String updateUser(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return USER_FORM_PAGE;
        }

        userService.update(user);
        return REDIRECT_OWN_PAGE;
    }
}
