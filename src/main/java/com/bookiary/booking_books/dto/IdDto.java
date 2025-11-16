package com.bookiary.booking_books.dto;

import jakarta.validation.constraints.NotNull;

public record IdDto(
        @NotNull
        Long id
) {
}
