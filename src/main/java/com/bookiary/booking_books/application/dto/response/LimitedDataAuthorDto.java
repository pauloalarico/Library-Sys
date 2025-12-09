package com.bookiary.booking_books.application.dto.response;

import java.time.LocalDate;

public record LimitedDataAuthorDto(
        String name,
        LocalDate birthDate,
        String nationality
) {
}
