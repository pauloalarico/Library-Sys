package com.bookiary.booking_books.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
