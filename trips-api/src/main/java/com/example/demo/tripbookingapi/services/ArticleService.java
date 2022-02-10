package com.example.demo.tripbookingapi.services;

import com.example.demo.tripbookingapi.services.dto.JsonObjectResponse;

public interface ArticleService {

  JsonObjectResponse find(Long id, String language, String fields);
}
