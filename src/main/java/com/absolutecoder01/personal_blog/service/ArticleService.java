package com.absolutecoder01.personal_blog.service;

import com.absolutecoder01.personal_blog.domain.Article;

import java.util.UUID;
import java.util.List;

public interface ArticleService {
    Article getArticle(UUID id);
    List<Article> getAllArticles();
    Article addArticle(Article article);
    Article updateArticle(Article article);
    void deleteArticle(UUID id);
}
