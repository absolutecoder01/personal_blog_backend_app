package com.absolutecoder01.personal_blog.service;

import com.absolutecoder01.personal_blog.domain.Article;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;
import java.util.List;

public interface ArticleService {
    Article getArticle(UUID id);
    List<Article> getAllArticles() throws IOException;
    Article addArticle(Article article);
    Article updateArticle(Article article);
    void deleteArticle(UUID id);
}
