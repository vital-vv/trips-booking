package com.example.demo.tripsapi.test.domain

import com.example.demo.tripbookingapi.domain.Article
import com.example.demo.tripbookingapi.domain.ArticleTranslation
import com.example.demo.tripbookingapi.domain.enumeration.Language

final class Articles {
  static Article _1() {
    def article = new Article(
        id: 1L,
        imageId: 'f0ddbcaa-8c66-4995-9da8-dc59ceca3f26',
        trip: Trips._1()
    )
    article.setArticleTranslations([
        Language.EN: new ArticleTranslation(
            title: 'Food',
            text: 'A text about the cuisine in the country which you visit during the trip',
            article: article)
    ])
    article
  }
}
