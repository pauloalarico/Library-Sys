package com.bookiary.booking_books.application.dto.request;

import com.bookiary.booking_books.domain.enums.Category;
import com.bookiary.booking_books.domain.model.Book;

public record ListBooksDto(
        String title,
        String isbn,
        AuthorDto author,
        Category category,
        Integer avaibleQuantity
) {
    public ListBooksDto(Book book) {
        this(book.getTitle(), book.getIsbn(),
                new AuthorDto(book.getAuthor().getName(),
                book.getAuthor().getBirthDate(),
                book.getAuthor().getNationality()),
                book.getCategory(), book.getQuantityAvaible());
    }
}
