package com.newsportal.controller;

import com.newsportal.entity.User;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/news/user")
public class UserController {

    private static final String OWN_PAGE = "own_page";
    private static final String FAVOURITE_NEWS = "favourite_news";

    private static final String USER_ATTRIBUTE = "user";
    private static final String FAVOURITE_NEWS_ATTRIBUTE = "favouriteNewsList";

    @Autowired
    private UserService userService;

    @GetMapping("/own_page")
    public String ownPage(Principal principal, Model model) {
        Optional<User> user = userService.getUser(principal.getName());
        model.addAttribute(USER_ATTRIBUTE, user.get());
        return OWN_PAGE;
    }

    @GetMapping("/favourite_news")
    public String favouriteNews(Principal principal, Model model) {
        Optional<User> user = userService.getUser(principal.getName());
        model.addAttribute(FAVOURITE_NEWS_ATTRIBUTE, user.get().getFavouriteNews());
        return FAVOURITE_NEWS;
    }
}
