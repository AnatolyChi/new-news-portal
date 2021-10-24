package com.newsportal.controller;

import com.newsportal.entity.User;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    private static final String USER_ATTRIBUTE = "user";
    private static final String SIGN_UP_PAGE = "sign_up";
    private static final String LOG_IN_PAGE = "login";
    private static final String ACCESS_DENIED_PAGE = "access_denied";
    private static final String AUTH_MAIN_FORM_PAGE = "main_form";
    private static final String REDIRECT_REG_ERROR = "redirect:/sign_up?error_add=1";
    private static final String REDIRECT_REG_SUCCESS = "redirect:/login?registration_ok=1";

    @Autowired
    private UserService userService;

    @InitBinder
    private void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping("/access_denied")
    public String showAccessDenied() {
        return ACCESS_DENIED_PAGE;
    }

    @RequestMapping("/welcome")
    public String base() {
        return AUTH_MAIN_FORM_PAGE;
    }

    @GetMapping("/sign_up")
    public String getSignUpPage(Model model) {
        model.addAttribute(USER_ATTRIBUTE, new User());
        return SIGN_UP_PAGE;
    }

    @PostMapping("/sign_up")
    public String performSignUp(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return SIGN_UP_PAGE;
        } else if (!userService.saveUser(user)) {
            return REDIRECT_REG_ERROR;
        }

        return REDIRECT_REG_SUCCESS;
    }

    @GetMapping("/login")
    public String getLogInPage(Model model) {
        model.addAttribute(USER_ATTRIBUTE, new User());
        return LOG_IN_PAGE;
    }
}
