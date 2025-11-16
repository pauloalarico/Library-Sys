package com.bookiary.booking_books.dto;

import com.bookiary.booking_books.enums.Category;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record NewBookDto(
        @NotBlank
        String title,
        @NotBlank
        @Pattern(
                regexp = "^(?:978-?)?(?:\\d{2}-?)?\\d{4,7}-?\\d{2,6}-?\\d$",
                message = "Invalide ISBN."
        )
        String isbn,
        @NotNull
        @Valid
        AuthorDto authorDto,
        @NotNull
        @Valid
        BookPublisherDto bookPublisherDto,
        @NotNull
        Integer publicationYear,
        @NotNull
        Category category,
        @NotNull
        Integer quantityAvaible,
        @NotNull
        LocationDto locationDto
) {
}
