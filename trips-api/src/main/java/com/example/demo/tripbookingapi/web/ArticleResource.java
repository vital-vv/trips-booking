package com.example.demo.tripbookingapi.web;

import com.example.demo.tripbookingapi.services.ArticleService;
import com.example.demo.tripbookingapi.services.dto.JsonErrorsResponse;
import com.example.demo.tripbookingapi.services.dto.JsonObjectResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Articles")
@RestController
@RequestMapping(path = ArticleResource.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ArticleResource {

  public static final String PATH = "/v1/articles";

  private final ArticleService articleService;

  @Operation(summary = "Find an article by id", responses = {
      @ApiResponse(responseCode = "200", description = "OK, completed without errors"),
      @ApiResponse(responseCode = "400", description = "Invalid parameters has been provided", content = @Content(
          schema = @Schema(implementation = JsonErrorsResponse.class))),
      @ApiResponse(responseCode = "404", description = "Article not found by id", content = @Content)
  })
  @GetMapping("{id}")
  public ResponseEntity<JsonObjectResponse> getArticleById(
      @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
      @PathVariable("id") Long id,
      @RequestParam("fields") String fields) {

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_LANGUAGE, "en")
        .body(articleService.find(id, language, fields));
  }
}
