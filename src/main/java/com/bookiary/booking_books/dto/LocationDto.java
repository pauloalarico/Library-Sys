package com.bookiary.booking_books.dto;

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
