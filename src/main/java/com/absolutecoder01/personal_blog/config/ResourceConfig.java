package com.absolutecoder01.personal_blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Bean
    public PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver() {
        return new PathMatchingResourcePatternResolver();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/homepage");
    }
}
