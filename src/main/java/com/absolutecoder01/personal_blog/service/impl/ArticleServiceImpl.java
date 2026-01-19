package com.absolutecoder01.personal_blog.service.impl;

import com.absolutecoder01.personal_blog.domain.Article;
import com.absolutecoder01.personal_blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final String ARTICLES_DIR = "articles";

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Article getArticle(UUID id) {
        try {
            Path path = Paths.get(ARTICLES_DIR, id + ".json");
            return objectMapper.readValue(path.toFile(), Article.class);
        } catch (Exception e) {
            throw new RuntimeException("Nie znaleziono artykułu");
        }
    }

    @Override
    public List<Article> getAllArticles() throws IOException {
        List<Article> articles = new ArrayList<>();
        Path dir = Paths.get(ARTICLES_DIR);

        if (!Files.exists(dir)) Files.createDirectories(dir);

        try (Stream<Path> paths = Files.list(dir)) {
            paths.filter(p -> p.toString().endsWith(".json"))
                    .forEach(p -> {
                        try {
                            articles.add(objectMapper.readValue(p.toFile(), Article.class));
                        } catch (Exception ignored) {}
                    });
        }

        return articles;
    }

    @Override
    public Article addArticle(Article article) {
        try {
            article.setId(UUID.randomUUID());
            article.onCreate();

            Path path = Paths.get(ARTICLES_DIR, article.getId() + ".json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), article);

            return article;
        } catch (Exception e) {
            throw new RuntimeException("Błąd zapisu artykułu", e);
        }
    }

    @Override
    public Article updateArticle(Article article) {
        try {
            article.onUpdate();
            Path path = Paths.get(ARTICLES_DIR, article.getId() + ".json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), article);
            return article;
        } catch (Exception e) {
            throw new RuntimeException("Błąd aktualizacji artykułu", e);
        }
    }

    @Override
    public void deleteArticle(UUID id) {
        try {
            Files.deleteIfExists(Paths.get(ARTICLES_DIR, id + ".json"));
        } catch (Exception e) {
            throw new RuntimeException("Błąd usuwania artykułu", e);
        }
    }
}
