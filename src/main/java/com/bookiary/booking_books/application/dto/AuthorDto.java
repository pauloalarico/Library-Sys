package com.bookiary.booking_books.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AuthorDto(
        @NotBlank
        String name,
        @NotNull
        LocalDate birthDate,
        @NotBlank
        String nationality
) {
        public AuthorDto(
                         String name,
                         LocalDate birthDate,
                         String nationality) {
                this.name = name;
                this.birthDate = birthDate;
                this.nationality = nationality;
        }
}
