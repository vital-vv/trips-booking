package com.example.demo.tripbookingapi.web;

import com.example.demo.tripbookingapi.services.dto.JsonArrayResponse;
import com.example.demo.tripbookingapi.services.dto.JsonArrayResponse.Meta;
import com.example.demo.tripbookingapi.services.dto.JsonErrorsResponse;
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

@Tag(name = "Available countries")
@RestController
@RequestMapping(path = CountryResource.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryResource {

  public static final String PATH = "/v1/countries";

  @Operation(summary = "Find countries which match the specified criteria", responses = {
      @ApiResponse(responseCode = "200", description = "OK, completed without errors"),
      @ApiResponse(responseCode = "400", description = "Invalid parameters has been provided", content = @Content(
          schema = @Schema(implementation = JsonErrorsResponse.class)))
  })
  @PostMapping("find")
  public ResponseEntity<JsonArrayResponse> findCountries(
      @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
      @RequestBody @Valid Search search) {

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_LANGUAGE, "en")
        .body(new JsonArrayResponse(
            new Meta(1, 2, 2, false),
            List.of(
                new JsonObject(1L, "Country", Map.of(
                    "name", "Belarus"
                )),
                new JsonObject(2L, "Country", Map.of(
                    "name", "Belgium"
                ))
            ), null
        )); // TODO
  }

  @Operation(summary = "Find available catering in the specified country", responses = {
      @ApiResponse(responseCode = "200", description = "OK, completed without errors"),
      @ApiResponse(responseCode = "400", description = "Invalid parameters has been provided", content = @Content(
          schema = @Schema(implementation = JsonErrorsResponse.class))),
      @ApiResponse(responseCode = "404", description = "The specified page does not exist", content = @Content)
  })
  @GetMapping("{id}/relationships/caterings")
  public ResponseEntity<JsonArrayResponse> findCountryCaterings(
      @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
      @PathVariable("id") Long id,
      @RequestParam("fields") String fields,
      Pageable pageable
  ) {

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_LANGUAGE, "en")
        .body(new JsonArrayResponse(
            new Meta(1, 2, 2, false),
            List.of(
                new JsonObject(1L, "Caterings", Map.of(
                    "name", "Sakura",
                    "imageId", "2d0bb2ef-c24d-42c7-a686-e43c2441f85b"
                )),
                new JsonObject(2L, "Caterings", Map.of(
                    "name", "Kimonichi",
                    "imageId", "97d0d468-63e2-4d10-ad8c-6f6b47074bd8"
                ))
            ), null
        )); // TODO
  }
}
