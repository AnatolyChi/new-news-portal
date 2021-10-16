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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthenticationController {

    private static final String USER_ATTRIBUTE = "user";
    private static final String SIGN_UP_PAGE = "sign_up";
    private static final String LOG_IN_PAGE = "login";
    private static final String ACCESS_DENIED_PAGE = "access_denied";
    private static final String AUTH_MAIN_FORM_PAGE = "main_form";
    private static final String NEWS_MAIN_URL = "/news/";

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest session;

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
    public String initSignUp(Model model) {
        model.addAttribute(USER_ATTRIBUTE, new User());
        return SIGN_UP_PAGE;
    }

    @PostMapping("/sign_up")
    public String createSignUp(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return SIGN_UP_PAGE;
        } else if (!userService.saveUser(user)) {

            // сообщение о существовании введенного логина
            return SIGN_UP_PAGE;
        }

//        session.getSession().setAttribute(USER_ATTRIBUTE, user);

        // редирект на страницу логина с сообщением об успешной регистрации
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String initLogIn(Model model) {
        model.addAttribute(USER_ATTRIBUTE, new User());
        return LOG_IN_PAGE;
    }

//    @PostMapping("/log_in")
//    public String createLogIn(@Valid @ModelAttribute User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return LOG_IN_PAGE;
//        }
//
//        Optional<User> userOptional = userService.getUser(user.getUsername(), user.getPassword());
//        if (userOptional.isPresent()) {
//            session.getSession().setAttribute(USER_ATTRIBUTE, userOptional.get());
//            return "redirect:" + NEWS_MAIN_URL;
//        }
//
//        // сообщение о неверности логина или пароля
//        return LOG_IN_PAGE;
//    }

//    @GetMapping("/log_out")
//    public String destroyUser() {
//        session.getSession().invalidate();
//        return "redirect:" + NEWS_MAIN_URL;
//    }
}
