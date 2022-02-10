package com.example.demo.tripbookingapi.web;

import com.example.demo.tripbookingapi.services.dto.JsonArrayResponse;
import com.example.demo.tripbookingapi.services.dto.JsonArrayResponse.Meta;
import com.example.demo.tripbookingapi.services.dto.JsonErrorsResponse;
import com.example.demo.tripbookingapi.services.dto.JsonObjectResponse;
import com.example.demo.tripbookingapi.services.dto.common.JsonObject;
import com.example.demo.tripbookingapi.web.vm.Pageable;
import com.example.demo.tripbookingapi.web.vm.Search;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Available hotels")
@RestController
@RequestMapping(path = HotelResource.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelResource {

  public static final String PATH = "/v1/hotels";

  @Operation(summary = "Find hotels which match the specified criteria", responses = {
      @ApiResponse(responseCode = "200", description = "OK, completed without errors"),
      @ApiResponse(responseCode = "400", description = "Invalid parameters has been provided", content = @Content(
          schema = @Schema(implementation = JsonErrorsResponse.class)))
  })
  @PostMapping("find")
  public ResponseEntity<JsonArrayResponse> findHotels(
      @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
      @RequestBody @Valid Search search) {

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_LANGUAGE, "en")
        .body(new JsonArrayResponse(
            new Meta(1, 3, 3, false),
            List.of(
                new JsonObject(1L, "Hotel", Map.of(
                    "name", "Plaza",
                    "imageId", "9ea2fc94-51cc-4631-bb12-594a80258640"
                )),
                new JsonObject(2L, "Hotel", Map.of(
                    "name", "Resort",
                    "imageId", "86bb690f-a59f-4636-9eb4-d552385e5e5e"
                )),
                new JsonObject(3L, "Hotel", Map.of(
                    "name", "Paradiso",
                    "imageId", "719fc5a8-aa69-40ee-a1bb-6ba9c4cb78aa"
                ))
            ), null
        ));
  }

  @Operation(summary = "Find a hotel by id", responses = {
      @ApiResponse(responseCode = "200", description = "OK, completed without errors"),
      @ApiResponse(responseCode = "400", description = "Invalid parameters has been provided", content = @Content(
          schema = @Schema(implementation = JsonErrorsResponse.class))),
      @ApiResponse(responseCode = "404", description = "Hotel not found by id", content = @Content)
  })
  @GetMapping("{id}")
  public ResponseEntity<JsonObjectResponse> findHotelById(
      @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
      @PathVariable("id") Long id,
      @RequestParam("fields") String fields) {

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_LANGUAGE, "en")
        .body(new JsonObjectResponse(
            new JsonObject(4L, "Hotel", Map.of(
                "name", "Transylvania hotel",
                "imageId", "6a067527-8d4c-4e9d-a3a3-58efa195473a",
                "description", "A hotel located in Rome",
                "rating", 4.7F
            )), null
        )); // TODO
  }

  @Operation(summary = "Find reviews for the specified hotel", responses = {
      @ApiResponse(responseCode = "200", description = "OK, completed without errors"),
      @ApiResponse(responseCode = "400", description = "Invalid parameters has been provided", content = @Content(
          schema = @Schema(implementation = JsonErrorsResponse.class))),
      @ApiResponse(responseCode = "404", description = "The specified page does not exist", content = @Content)
  })
  @GetMapping("{id}/relationships/reviews")
  public ResponseEntity<JsonArrayResponse> findHotelReviews(
      @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
      @PathVariable("id") Long id,
      @RequestParam("fields") String fields,
      Pageable pageable) {

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_LANGUAGE, "en")
        .body(new JsonArrayResponse(
            new Meta(1, 1, 1, false),
            List.of(
                new JsonObject(1L, "Review", Map.of(
                    "title", "A nice hotel",
                    "text", "This was the best hotel I have ever been to",
                    "rating", 5
                ))
            ), null
        )); // TODO
  }
}
