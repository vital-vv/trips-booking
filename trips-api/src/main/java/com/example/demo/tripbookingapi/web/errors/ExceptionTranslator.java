package com.example.demo.tripbookingapi.web.errors;

import com.example.demo.tripbookingapi.services.dto.JsonErrorsResponse;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body,
      HttpHeaders headers, HttpStatus status,
      WebRequest request) {

    String language = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
    if (language != null) {
      headers.computeIfAbsent(HttpHeaders.CONTENT_LANGUAGE, key -> List.of(language));
    }
    headers.computeIfAbsent(HttpHeaders.CONTENT_TYPE, key -> List.of(MediaType.APPLICATION_JSON_VALUE));

    body = new JsonErrorsResponse(Collections.singletonList(ex.getMessage()));

    return super.handleExceptionInternal(ex, body, headers, status, request);
  }
}
