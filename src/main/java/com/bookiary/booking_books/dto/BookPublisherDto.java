package com.bookiary.booking_books.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookPublisherDto(
        @NotBlank
        String name,
        @NotNull
        Integer foundationYear
) {

}
