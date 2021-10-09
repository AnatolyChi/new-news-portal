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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewsController {

    private static final String MAIN_PAGE = "main";
    private static final String ADD_NEWS_PAGE = "add_news";
    private static final String UPDATE_NEWS_PAGE = "update_news";
    private static final String NEWS_MAIN_URL = "/news/main";
    private static final String NEWS_ATTRIBUTE = "news";

    @Autowired
    private NewsService newsService;

    @Autowired
    private HttpServletRequest session;

    @InitBinder
    private void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping("/")
    public String base() {
        return "main";
    }

    @RequestMapping("/main")
    public String mainNews(@RequestParam(defaultValue = "1") int page, Model model) {
        List<News> newsList = newsService.getListNews(page);
        int newsCount = newsService.newsCount();

        // чтобы избежать проверок с дробной частью
        int pagesCount = (newsCount + 5) / 6;

        model.addAttribute("page", page);
        model.addAttribute("newsCount", newsCount);
        model.addAttribute("pagesCount", pagesCount);
        model.addAttribute("newsList", newsList);
        return MAIN_PAGE;
    }

    @GetMapping("/add_news")
    public String addNewsPage(Model model) {
        model.addAttribute("news", new News());
        return ADD_NEWS_PAGE;
    }

    @PostMapping("/add_news")
    public String addNews(@Valid News news, BindingResult result) {
        if (result.hasErrors()) {
            return ADD_NEWS_PAGE;
        }

        if (newsService.getNews(news.getTitle()).isEmpty()) {
            news.setUser((User) session.getSession().getAttribute("user"));
            newsService.saveNews(news);
            return "redirect:" + NEWS_MAIN_URL;
        }

        return ADD_NEWS_PAGE;
    }

    @RequestMapping("/read/{newsId}")
    public String readNews(@PathVariable("newsId") int newsId, Model model) {
        model.addAttribute(NEWS_ATTRIBUTE, newsService.getNews(newsId));
        return "read_news";
    }

    @RequestMapping("/delete/{newsId}")
    public String deleteNews(@PathVariable("newsId") int newsId) {
        newsService.deleteNews(newsId);
        return "redirect:" + NEWS_MAIN_URL;
    }

    @GetMapping("/update/{newsId}")
    public String updateNewsPage(@PathVariable("newsId") int newsId, Model model) {
        model.addAttribute("news", newsService.getNews(newsId));
        return UPDATE_NEWS_PAGE;
    }

    @PostMapping("/update/{newsId}")
    public String updateNews(@Valid News news, BindingResult result, @PathVariable("newsId") int newsId) {
        if (result.hasErrors()) {
            return UPDATE_NEWS_PAGE;
        }

        news.setId(newsId);
        newsService.updateNews(news);
        return "redirect:" + NEWS_MAIN_URL;
    }

    @GetMapping("/favourite_news")
    public String favouriteNews() {
        return "favourite_news";
    }
}
