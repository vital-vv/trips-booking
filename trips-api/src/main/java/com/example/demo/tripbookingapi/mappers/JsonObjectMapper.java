package com.example.demo.tripbookingapi.mappers;

import com.example.demo.tripbookingapi.domain.Article;
import com.example.demo.tripbookingapi.domain.Trip;
import com.example.demo.tripbookingapi.services.dto.common.JsonObject;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = JacksonMapMapper.class)
public interface JsonObjectMapper {

  @Mapping(target = "type", expression = "java(trip.getClass().getSimpleName())")
  @Mapping(target = "attributes", source = "trip")
  JsonObject map(Trip trip, String... fields);

  @Mapping(target = "type", expression = "java(article.getClass().getSimpleName())")
  @Mapping(target = "attributes", source = "article")
  JsonObject map(Article article, String... fields);
}
