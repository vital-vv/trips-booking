package com.example.demo.tripbookingapi.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.tripbookingapi.domain.Article;
import com.example.demo.tripbookingapi.domain.Trip;
import com.example.demo.tripbookingapi.domain.enumeration.Language;
import com.example.demo.tripbookingapi.services.dto.common.JsonObject;
import com.example.demo.tripsapi.test.domain.Articles;
import com.example.demo.tripsapi.test.domain.Trips;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig({JsonObjectMapperImpl.class, JacksonMapMapper.class})
class JsonObjectMapperTest {

  @Autowired
  private JsonObjectMapper mapper;

  @Test
  void testConvertTripToJsonObject() {
    Language language = Language.EN;
    Trip expected = Trips._1();
    JsonObject actual = mapper.map(expected, "name", "shortDescription",
        "fullDescription", "cuisine", "rating", "country");

    assertEquals(expected.getId(), actual.id());
    assertEquals("Trip", actual.type());
    assertEquals(expected.getName(language), actual.attributes().get("name"));
    assertEquals(expected.getDescription(language), actual.attributes().get("shortDescription"));
    assertEquals(expected.getSpecification(language), actual.attributes().get("fullDescription"));
    assertEquals(expected.getCuisine(language), actual.attributes().get("cuisine"));
    assertEquals(expected.getRating(), actual.attributes().get("rating"));
    assertEquals(expected.getCountry().getId(), actual.attributes().get("country"));
  }

  @Test
  void testConvertArticleToJsonObject() {
    Language language = Language.EN;
    Article expected = Articles._1();
    JsonObject actual = mapper.map(expected, "title", "text", "imageId");

    assertEquals(expected.getId(), actual.id());
    assertEquals("Article", actual.type());
    assertEquals(expected.getTitle(language), actual.attributes().get("title"));
    assertEquals(expected.getText(language), actual.attributes().get("text"));
    assertEquals(expected.getImageId(), actual.attributes().get("imageId"));
  }
}
