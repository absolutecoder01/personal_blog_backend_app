package com.absolutecoder01.personal_blog.controller;

import com.absolutecoder01.personal_blog.domain.Article;
import com.absolutecoder01.personal_blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.List;

@Controller
public class HomePageController {

    ArticleService articleService;

    public HomePageController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String homepageRoot(Model model) {
        return "redirect:/homepage";
    }

    @GetMapping("/homepage")
    public String display_homepage(
            @RequestParam(name = "homepage", required = false, defaultValue = "User")
            String name,
            Model model
    ) {
        try {
            model.addAttribute("articles", articleService.getAllArticles());
        } catch (IOException e) {
            model.addAttribute("articles", List.of());
            model.addAttribute("error", "Nie można załadować artykułów");
        }
        model.addAttribute("name", name);
        return "homepage";
    }

}
