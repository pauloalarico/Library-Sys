package com.bookiary.booking_books.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LocationDto(
        @NotBlank
        String section,
        @NotBlank
        String bookShelf,
        @NotBlank
        String shelf
) {
}
