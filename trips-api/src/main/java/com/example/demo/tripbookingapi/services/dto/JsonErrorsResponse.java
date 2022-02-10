package com.example.demo.tripbookingapi.services.dto;

import java.util.Collection;

public record JsonErrorsResponse(
    Collection<String> errors
) {

}
