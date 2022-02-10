package com.example.demo.tripbookingapi.web.vm;

import java.util.Map;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import org.springframework.lang.Nullable;

public record Search(
    Map<String, Map<String, Object>> criteria,
    @PositiveOrZero int page,
    @Positive @Max(100) int size,
    @Nullable String sortBy,
    @NotBlank String fields
) {

}
