package com.example.demo.tripbookingapi.mappers;

import com.example.demo.tripbookingapi.domain.Article;
import com.example.demo.tripbookingapi.domain.Trip;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import java.util.Collections;
import java.util.Map;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class JacksonMapMapper {

  private static final ObjectMapper mapper = new ObjectMapper();
  private static final MapType mapType = mapper.getTypeFactory()
      .constructMapType(Map.class, String.class, Object.class);

  @NonNull
  Map<String, Object> map(@NonNull Trip trip) {
    final Map<String, Object> map = mapper.convertValue(trip, mapType);
    map.put("shortDescription", map.remove("description"));
    map.put("fullDescription", map.remove("specification"));
    map.put("country", ((Map<?, ?>) map.getOrDefault("country", Collections.emptyMap())).get("id"));
    return map;
  }

  @NonNull
  Map<String, Object> map(@NonNull Article article) {
    return mapper.convertValue(article, mapType);
  }
}
