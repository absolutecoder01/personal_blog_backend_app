package com.absolutecoder01.personal_blog.controller;

import com.absolutecoder01.personal_blog.domain.Article;
import com.absolutecoder01.personal_blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Article> getAllArticles() throws IOException {
        return service.getAllArticles();
    }

    @PostMapping
    public String addArticle(Article article) {
        service.addArticle(article);
        return "redirect:/homepage";
    }

    @PutMapping
    public String updateArticle(Article article) {
        service.updateArticle(article);
        return "redirect:/homepage";
    }

    @GetMapping(path = "/{id}")
    public Article getArticle(@PathVariable UUID id) {
        return service.getArticle(id);
    }

    @DeleteMapping(path = "{id}")
    void deleteArticle(@PathVariable UUID id) {
        service.deleteArticle(id);
    }



}
