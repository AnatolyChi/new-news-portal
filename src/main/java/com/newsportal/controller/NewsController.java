package com.newsportal.controller;

import com.newsportal.entity.News;
import com.newsportal.entity.User;
import com.newsportal.service.NewsService;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewsController {

    private static final String MAIN_PAGE = "main_news";
    private static final String ADD_NEWS_PAGE = "add_news";
    private static final String UPDATE_NEWS_PAGE = "update_news";
    private static final String READ_NEWS_PAGE = "read_news";
    private static final String OFFER_NEWS_PAGE = "offer_news";
    private static final String NEWS_MAIN_URL_REDIRECT = "redirect:/news/";
    private static final String READ_NEWS_REDIRECT = "redirect:/news/read/";

    private static final String NEWS_ATTRIBUTE = "news";
    private static final String PAGE_ATTRIBUTE = "page";
    private static final String NEWS_COUNT_ATTRIBUTE = "newsCount";
    private static final String PAGES_COUNT_ATTRIBUTE = "pagesCount";
    private static final String NEWS_LIST_ATTRIBUTE = "newsList";

    private static final String ERROR_ADD_FAVOURITE_PARAM = "?error_add=1";
    private static final String ERROR_DELETE_FAVOURITE_PARAM = "?error_delete=1";
    private static final String SUCCESS_ADD_FAVOURITE_PARAM = "?success_add=1";
    private static final String SUCCESS_DELETE_FAVOURITE_PARAM = "?success_delete=1";

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

    @InitBinder
    private void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping("/")
    public String mainNews(@RequestParam(defaultValue = "1") int page, Model model) {
        List<News> newsList = newsService.getListNews(page);
        int newsCount = newsService.newsCount();

        // чтобы избежать проверок с дробной частью
        int pagesCount = (newsCount + 5) / 6;

        model.addAttribute(PAGE_ATTRIBUTE, page);
        model.addAttribute(NEWS_COUNT_ATTRIBUTE, newsCount);
        model.addAttribute(PAGES_COUNT_ATTRIBUTE, pagesCount);
        model.addAttribute(NEWS_LIST_ATTRIBUTE, newsList);
        return MAIN_PAGE;
    }

    @GetMapping("/add_news")
    public String addNewsPage(Model model) {
        model.addAttribute(NEWS_ATTRIBUTE, new News());
        return ADD_NEWS_PAGE;
    }

    @PostMapping("/add_news")
    public String addNews(@Valid News news, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return ADD_NEWS_PAGE;
        }

        Optional<User> user = userService.getUser(principal.getName());
        if (user.isPresent()) {
            if (newsService.getNews(news.getTitle()).isEmpty()) {
                news.setUser(user.get());
                newsService.saveNews(news);
                return NEWS_MAIN_URL_REDIRECT;
            }
        }

        return ADD_NEWS_PAGE;
    }

    @RequestMapping("/read/{newsId}")
    public String readNews(@PathVariable("newsId") int newsId, Model model) {
        model.addAttribute(NEWS_ATTRIBUTE, newsService.getNews(newsId));
        return READ_NEWS_PAGE;
    }

    @DeleteMapping("/delete/{newsId}")
    public String deleteNews(@PathVariable("newsId") int newsId) {
        newsService.deleteNews(newsId);
        return NEWS_MAIN_URL_REDIRECT;
    }

    @GetMapping("/update/{newsId}")
    public String updateNewsPage(@PathVariable("newsId") int newsId, Model model) {
        model.addAttribute(NEWS_ATTRIBUTE, newsService.getNews(newsId));
        return UPDATE_NEWS_PAGE;
    }

    @PutMapping("/update/{newsId}")
    public String updateNews(@Valid News news, BindingResult result, @PathVariable("newsId") int newsId) {
        if (result.hasErrors()) {
            return UPDATE_NEWS_PAGE;
        }

        news.setId(newsId);
        newsService.updateNews(news);
        return NEWS_MAIN_URL_REDIRECT;
    }

    @RequestMapping("/favourite_add/{newsId}")
    public String favouriteNewsAdd(@PathVariable("newsId") int newsId, Principal principal) {
        Optional<User> user = userService.getUser(principal.getName());

        if (user.isPresent()) {
            if (newsService.addToFavourite(user.get().getId(), newsId)) {
                return READ_NEWS_REDIRECT + newsId + SUCCESS_ADD_FAVOURITE_PARAM;
            }
        }

        return READ_NEWS_REDIRECT + newsId + ERROR_ADD_FAVOURITE_PARAM;
    }

    @RequestMapping("/favourite_delete/{newsId}")
    public String favouriteNewsDelete(@PathVariable("newsId") int newsId, Principal principal) {
        Optional<User> user = userService.getUser(principal.getName());

        if (user.isPresent()) {
            if (newsService.deleteFromFavourite(user.get().getId(), newsId)) {
                return READ_NEWS_REDIRECT + newsId + SUCCESS_DELETE_FAVOURITE_PARAM;
            }
        }

        return READ_NEWS_REDIRECT + newsId + ERROR_DELETE_FAVOURITE_PARAM;
    }

    @GetMapping("/offer_news")
    public String offerNews(Model model) {
        model.addAttribute(NEWS_ATTRIBUTE, new News());
        return OFFER_NEWS_PAGE;
    }
}
