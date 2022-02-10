package com.example.demo.tripbookingapi.services.dto;

import com.example.demo.tripbookingapi.services.dto.common.JsonObject;
import java.util.Collection;
import org.springframework.lang.Nullable;

public record JsonObjectResponse(
    @Nullable JsonObject data,
    @Nullable Collection<String> errors
) {

}
