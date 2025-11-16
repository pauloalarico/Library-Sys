package com.bookiary.booking_books.application.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateDataDto(
        @NotNull
        Long id,
        Integer avaibleQuantity,
        LocationDto location,
        BookPublisherDto bookPublisher
        ) {
}
