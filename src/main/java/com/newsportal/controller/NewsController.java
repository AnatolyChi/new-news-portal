package com.newsportal.controller;

import com.newsportal.entity.News;
import com.newsportal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

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
}
