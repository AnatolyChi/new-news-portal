package com.newsportal.controller;

import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/news/user")
public class UserController {

    private static final String OWN_PAGE = "own_page";

    @Autowired
    private UserService userService;

    @GetMapping("/own_page")
    public String ownPage() {
        return OWN_PAGE;
    }
}
