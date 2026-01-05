package com.absolutecoder01.personal_blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Article {

    int id;
    String title;
    String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate updatedAt;
    String author;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", author='" + author + '\'' +
                '}';
    }

    @PrePersist
    protected void onCreate(){
        LocalDate now = LocalDate.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDate.now();
    }
}
