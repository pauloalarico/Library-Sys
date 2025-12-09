package com.bookiary.booking_books.application.dto.response;

import java.util.List;

public record ExceptionDto(
        String code,
        String message,
        List<ErrorsFieldDto> errors
) {
}
