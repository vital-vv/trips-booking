package com.example.demo.tripbookingapi.services.dto.common;

import java.util.Map;

public record JsonObject(
    Long id,
    String type,
    Map<String, Object> attributes
) {

}
