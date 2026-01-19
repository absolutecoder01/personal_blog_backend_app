package com.absolutecoder01.personal_blog.controller;

import org.springframework.ui.Model;
import com.absolutecoder01.personal_blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ArticlePageController {

    private final ArticleService articleService;

    public ArticlePageController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article/{id}")
    public String showArticle(@PathVariable UUID id, Model model) {
        model.addAttribute("article", articleService.getArticle(id));
        return "article";
    }
}

