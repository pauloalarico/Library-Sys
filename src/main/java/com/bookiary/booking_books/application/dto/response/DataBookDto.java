package com.bookiary.booking_books.application.dto.response;

import com.bookiary.booking_books.domain.enums.Category;
import com.bookiary.booking_books.domain.model.Author;
import com.bookiary.booking_books.domain.model.Book;
import com.bookiary.booking_books.domain.model.BookPublisher;
import com.bookiary.booking_books.domain.model.Location;

public record DataBookDto(
        String title,
        String isbn,
        LimitedDataAuthorDto author,
        BookPublisher bookPublisher,
        Integer publicationYear,
        Category category,
        Integer quantityAvaible,
        Location location
) {
    public DataBookDto(Book book) {
        this(book.getTitle(),
                book.getIsbn(),
                new LimitedDataAuthorDto(book.getAuthor().getName(),
                        book.getAuthor().getBirthDate(),
                        book.getAuthor().getNationality()),
                book.getBookPublisher(),
                book.getPublicationYear(),
                book.getCategory(),
                book.getQuantityAvaible(),
                book.getLocation()
        );
    }
}
