package com.example.demo.tripsapi.test.domain.repo

import com.example.demo.tripbookingapi.domain.Article
import com.example.demo.tripbookingapi.domain.repo.ArticleRepository
import com.example.demo.tripsapi.test.domain.repo.base.JpaRepositoryFake

class ArticleRepositoryFake extends JpaRepositoryFake<Article, Long> implements ArticleRepository {
}
