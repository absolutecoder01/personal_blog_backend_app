package com.absolutecoder01.personal_blog.controller;

import com.absolutecoder01.personal_blog.domain.Article;
import com.absolutecoder01.personal_blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ArticleService articleService;

    public AdminController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public String dashboard(Model model) throws Exception {
        model.addAttribute("articles", articleService.getAllArticles());
        return "admin/dashboard";
    }

    @GetMapping("/new")
    public String newArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "admin/form";
    }

    @PostMapping("/new")
    public String createArticle(@ModelAttribute Article article) {
        articleService.addArticle(article);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable UUID id, Model model) {
        model.addAttribute("article", articleService.getArticle(id));
        return "admin/form";
    }

    @PostMapping("/edit")
    public String updateArticle(@ModelAttribute Article article) {
        articleService.updateArticle(article);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        articleService.deleteArticle(id);
        return "redirect:/admin";
    }
}
