package com.bookiary.booking_books.application.dto.response;

public record ErrorsFieldDto(
        String field,
        String message
) {
}
