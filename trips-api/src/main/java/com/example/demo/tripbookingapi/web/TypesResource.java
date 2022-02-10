package com.example.demo.tripbookingapi.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collection;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Deprecated(forRemoval = true) // TODO: remove
@Tag(name = "Provides types description")
@RestController
@RequestMapping(path = TypesResource.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class TypesResource {

  public static final String PATH = "/v1/types";

  @GetMapping("Trip")
  public Collection<String> describeTrip() {
    return List.of("region", "imageId", "rating", "type", "country", "name", "description", "specification", "cuisine");
  }

  @GetMapping("Article")
  public Collection<String> describeArticle() {
    return List.of("imageId", "title", "text", "trip");
  }

  @GetMapping("Country")
  public Collection<String> describeCountry() {
    return List.of("code", "name");
  }

  @GetMapping("Hotel")
  public Collection<String> describeHotel() {
    return List.of("rating", "location", "imageId", "features", "name", "description");
  }

  @GetMapping("Catering")
  public Collection<String> describeCatering() {
    return List.of("name", "type", "imageId", "country");
  }

  @GetMapping("Reviews")
  public Collection<String> describeReviews() {
    return List.of("title", "text", "rating", "hotel", "language");
  }
}
