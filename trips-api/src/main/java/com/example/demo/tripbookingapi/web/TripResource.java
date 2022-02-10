package com.example.demo.tripbookingapi.web;

import com.example.demo.tripbookingapi.domain.enumeration.TripType;
import com.example.demo.tripbookingapi.services.dto.JsonArrayResponse;
import com.example.demo.tripbookingapi.services.dto.JsonArrayResponse.Meta;
import com.example.demo.tripbookingapi.services.dto.JsonErrorsResponse;
import com.example.demo.tripbookingapi.services.dto.JsonObjectResponse;
import com.example.demo.tripbookingapi.services.dto.common.JsonObject;
import com.example.demo.tripbookingapi.web.vm.Pageable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Available trips")
@RestController
@RequestMapping(path = TripResource.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class TripResource {

  public static final String PATH = "/v1/trips";

  @Operation(summary = "Find trips by type with sorting and pagination", responses = {
      @ApiResponse(responseCode = "200", description = "OK, completed without errors"),
      @ApiResponse(responseCode = "400", description = "Invalid parameters has been provided", content = @Content(
          schema = @Schema(implementation = JsonErrorsResponse.class))),
      @ApiResponse(responseCode = "404", description = "The specified page does not exist", content = @Content)
  })
  @GetMapping
  public ResponseEntity<JsonArrayResponse> findTripsByType(
      @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
      @RequestParam("type") TripType type,
      @RequestParam("fields") String fields,
      Pageable pageable) {

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_LANGUAGE, "en")
        .body(new JsonArrayResponse(
            new Meta(1, 3, 3, false),
            List.of(
                new JsonObject(1L, "Trip", Map.of(
                    "name", "Trip to Japan",
                    "imageId", "23b2d357-bf20-4f54-b4a7-a81c3425e0d9",
                    "description", "The journey of your life"
                )),
                new JsonObject(2L, "Trip", Map.of(
                    "name", "Hawaii",
                    "imageId", "b8e674ff-6120-46c6-b035-4fe02d5f3aef"
                )),
                new JsonObject(3L, "Trip", Map.of(
                    "name", "San Jose",
                    "imageId", "9a935272-a690-4b9d-883a-d41627e40204"
                ))
            ), null
        )); // TODO
  }

  @Operation(summary = "Find a trip by id", responses = {
      @ApiResponse(responseCode = "200", description = "OK, completed without errors"),
      @ApiResponse(responseCode = "400", description = "Invalid parameters has been provided", content = @Content(
          schema = @Schema(implementation = JsonErrorsResponse.class))),
      @ApiResponse(responseCode = "404", description = "Trip not found by id", content = @Content)
  })
  @GetMapping("{id}")
  public ResponseEntity<JsonObjectResponse> findTripById(
      @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
      @PathVariable("id") Long id,
      @RequestParam("fields") String fields) {

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_LANGUAGE, "en")
        .body(new JsonObjectResponse(
            new JsonObject(1L, "Trip", Map.of(
                "name", "Trip to Japan",
                "imageId", "23b2d357-bf20-4f54-b4a7-a81c3425e0d9",
                "shortDescription", "The journey of your life",
                "fullDescription", "A detailed description of the trip to Japan",
                "cuisine", "A short description of the japanese cuisine",
                "rating", 4.8F,
                "country", 1
            )), null
        )); // TODO
  }

  @Operation(summary = "Find articles about the specified trip with sorting and pagination", responses = {
      @ApiResponse(responseCode = "200", description = "OK, completed without errors"),
      @ApiResponse(responseCode = "400", description = "Invalid parameters has been provided", content = @Content(
          schema = @Schema(implementation = JsonErrorsResponse.class))),
      @ApiResponse(responseCode = "404", description = "The specified page does not exist", content = @Content)
  })
  @GetMapping("{id}/relationships/articles")
  public ResponseEntity<JsonArrayResponse> findTripArticles(
      @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
      @PathVariable("id") Long id,
      @RequestParam("fields") String fields,
      Pageable pageable
  ) {

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_LANGUAGE, "en")
        .body(new JsonArrayResponse(
            new Meta(1, 1, 1, false),
            List.of(
                new JsonObject(4L, "Article", Map.of(
                    "title", "Food",
                    "imageId", "f0ddbcaa-8c66-4995-9da8-dc59ceca3f26"
                ))
            ), null
        )); // TODO
  }
}
