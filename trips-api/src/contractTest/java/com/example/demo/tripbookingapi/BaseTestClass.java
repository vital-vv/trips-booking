package com.example.demo.tripbookingapi;

import com.example.demo.tripbookingapi.mappers.JacksonMapMapper;
import com.example.demo.tripbookingapi.mappers.JsonObjectMapperImpl;
import com.example.demo.tripbookingapi.services.impl.ArticleServiceImpl;
import com.example.demo.tripbookingapi.web.ArticleResource;
import com.example.demo.tripbookingapi.web.CountryResource;
import com.example.demo.tripbookingapi.web.HotelResource;
import com.example.demo.tripbookingapi.web.TripResource;
import com.example.demo.tripbookingapi.web.errors.ExceptionTranslator;
import com.example.demo.tripsapi.test.domain.repo.ArticleRepositoryFake;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public abstract class BaseTestClass {

  @BeforeEach
  public void setup() {
    final var mapper = new JsonObjectMapperImpl(new JacksonMapMapper());
    final var articleService = new ArticleServiceImpl(new ArticleRepositoryFake(), mapper);

    RestAssuredMockMvc.standaloneSetup(MockMvcBuilders
        .standaloneSetup(
            new ArticleResource(articleService),
            new CountryResource(),
            new HotelResource(),
            new TripResource())
        .setControllerAdvice(
            new ExceptionTranslator())
    );
  }
}
