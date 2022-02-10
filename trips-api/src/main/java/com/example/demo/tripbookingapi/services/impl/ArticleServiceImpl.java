package com.example.demo.tripbookingapi.services.impl;

import com.example.demo.tripbookingapi.domain.repo.ArticleRepository;
import com.example.demo.tripbookingapi.mappers.JsonObjectMapper;
import com.example.demo.tripbookingapi.services.ArticleService;
import com.example.demo.tripbookingapi.services.dto.JsonObjectResponse;
import com.example.demo.tripbookingapi.services.dto.common.JsonObject;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleRepository articleRepository;
  private final JsonObjectMapper mapper;

  @Override
  public JsonObjectResponse find(Long id, String language, String fields) {
    return new JsonObjectResponse(
        new JsonObject(1L, "Article", Map.of(
            "title", "Food",
            "text", "A text about the cuisine in the country which you visit during the trip",
            "imageId", "f0ddbcaa-8c66-4995-9da8-dc59ceca3f26"
        )), null
    );
  }
}
