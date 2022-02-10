package com.example.demo.tripbookingapi.services.dto;

import com.example.demo.tripbookingapi.services.dto.common.JsonObject;
import java.util.Collection;
import org.springframework.lang.Nullable;

public record JsonArrayResponse(
    Meta meta,
    @Nullable Collection<JsonObject> data,
    @Nullable Collection<String> errors
) {

  public record Meta(
      int page,
      int size,
      long count,
      boolean hasMore
  ) {

  }
}
