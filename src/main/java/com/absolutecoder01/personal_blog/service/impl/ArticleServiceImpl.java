package com.absolutecoder01.personal_blog.service.impl;

import com.absolutecoder01.personal_blog.domain.Article;
import com.absolutecoder01.personal_blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private PathMatchingResourcePatternResolver resolver;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Article getArticle(UUID id) {
        return null;
    }

    @Override
    public List<Article> getAllArticles() throws IOException {
        List<Article> allArticles = new ArrayList<>();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:articles/*.json");
        for (Resource resource : resources) {
            if(resource.exists()){
                List<Article> articles = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
                allArticles.addAll(articles);
            }
        }
        return allArticles;
    }

    @Override
    public Article addArticle(Article article) {
        return null;
    }

    @Override
    public Article updateArticle(Article article) {
        return null;
    }

    @Override
    public void deleteArticle(UUID id) {

    }
}
