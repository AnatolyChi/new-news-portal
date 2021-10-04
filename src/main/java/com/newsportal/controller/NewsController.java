package com.newsportal.controller;

import com.newsportal.entity.News;
import com.newsportal.entity.User;
import com.newsportal.service.NewsService;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private HttpServletRequest session;

    @RequestMapping("/")
    public String listNews() {
        return "main";
    }

    @RequestMapping("/main")
    public String mainNews(Model model) {
        List<News> newsList = newsService.getListNews();
        model.addAttribute("newsList", newsList);
        return "main";
    }

    @GetMapping("/add_news")
    public String addNewsPage(Model model) {
        model.addAttribute("news", new News());
        return "add_news";
    }

    @PostMapping("/add_news")
    public String addNews(@Valid News news, BindingResult result) {
        if (result.hasErrors()) {
            return "add_news";
        }
        if (newsService.getNews(news.getTitle()).isEmpty()) {
            news.setUser((User) session.getSession().getAttribute("user"));
            newsService.saveNews(news);
            return "redirect:/news/main";
        }

        return "add_news";
    }

    @RequestMapping("/read/{newsId}")
    public String readNews(@PathVariable("newsId") int newsId, Model model) {
        model.addAttribute("news", newsService.getNews(newsId));
        return "read_news";
    }

    @RequestMapping("/delete/{newsId}")
    public String deleteNews(@PathVariable("newsId") int newsId) {
        newsService.deleteNews(newsId);
        return "redirect:/news/main";
    }

    @GetMapping("/update/{newsId}")
    public String updateNewsPage(@PathVariable("newsId") int newsId, Model model) {
        model.addAttribute("news", newsService.getNews(newsId));
        return "update_news";
    }

    @PostMapping("/update/{newsId}")
    public String updateNews(@Valid News news, BindingResult result, @PathVariable("newsId") int newsId) {
        if (result.hasErrors()) {
            return "update_news";
        }

        news.setId(newsId);
        newsService.updateNews(news);
        return "redirect:/news/main";
    }

    @GetMapping("/favourite_news")
    public String favouriteNews() {
        return "favourite_news";
    }
}
