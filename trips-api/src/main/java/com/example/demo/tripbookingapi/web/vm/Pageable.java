package com.example.demo.tripbookingapi.web.vm;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import org.springframework.lang.Nullable;

public record Pageable(
    @PositiveOrZero int page,
    @Positive @Max(100) int size,
    @Nullable String sortBy
) {

}
