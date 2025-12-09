package com.bookiary.booking_books.application.dto.response;

public record GenericExceptionDto(
        String code,
        String message
) {
}
