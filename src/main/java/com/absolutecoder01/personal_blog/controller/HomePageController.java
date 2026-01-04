package com.absolutecoder01.personal_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class HomePageController {

    @GetMapping("/homepage")
    public String display_homepage(
            @RequestParam(name = "homepage", required = false, defaultValue = "User")
            String name,
            Model model
    ){
        model.addAttribute("name", name);
        return "homepage";

    }
}
