package com.example.demo.tripbookingapi.domain.repo;

import com.example.demo.tripbookingapi.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
