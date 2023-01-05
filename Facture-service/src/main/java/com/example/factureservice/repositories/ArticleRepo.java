package com.example.factureservice.repositories;

import com.example.factureservice.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
