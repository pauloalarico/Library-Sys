package com.bookiary.booking_books.dto;

import com.bookiary.booking_books.enums.Category;
import com.bookiary.booking_books.model.Book;

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
