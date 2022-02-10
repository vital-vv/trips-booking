package com.example.demo.tripbookingapi.mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.tripbookingapi.domain.Article;
import com.example.demo.tripbookingapi.domain.Trip;
import com.example.demo.tripbookingapi.domain.enumeration.Language;
import com.example.demo.tripsapi.test.domain.Articles;
import com.example.demo.tripsapi.test.domain.Trips;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(JacksonMapMapper.class)
class JacksonMapMapperTest {

  @Autowired
  private JacksonMapMapper mapper;

  @Test
  void testConvertTripToMap() {
    Language language = Language.EN;
    Trip expected = Trips._1();
    var map = mapper.map(expected);

    assertThat(map.keySet()).containsOnly("region", "imageId", "rating", "type", "country",
        "name", "description", "specification", "cuisine");
    assertEquals(expected.getRegion(), map.get("region"));
    assertEquals(expected.getImageId(), map.get("imageId"));
    assertEquals(expected.getRating(), map.get("rating"));
    assertEquals(expected.getType(), map.get("type"));
    assertEquals(expected.getCountry().getId(), map.get("country"));
    assertEquals(expected.getName(language), map.get("name"));
    assertEquals(expected.getDescription(language), map.get("description"));
    assertEquals(expected.getSpecification(language), map.get("specification"));
    assertEquals(expected.getCuisine(language), map.get("cuisine"));
  }

  @Test
  void testConvertArticleToMap() {
    Language language = Language.EN;
    Article expected = Articles._1();
    var map = mapper.map(expected);

    assertThat(map.keySet()).containsOnly("imageId", "title", "text", "trip");
    assertEquals(expected.getImageId(), map.get("imageId"));
    assertEquals(expected.getTitle(language), map.get("title"));
    assertEquals(expected.getText(language), map.get("text"));
    assertEquals(expected.getTrip().getId(), map.get("trip"));
  }
}
