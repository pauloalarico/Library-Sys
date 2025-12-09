package com.bookiary.booking_books.application.service;

import com.bookiary.booking_books.application.dto.request.ListBooksDto;
import com.bookiary.booking_books.application.dto.request.NewBookDto;
import com.bookiary.booking_books.application.dto.request.UpdateDataDto;
import com.bookiary.booking_books.domain.model.Author;
import com.bookiary.booking_books.domain.model.Book;
import com.bookiary.booking_books.domain.model.BookPublisher;
import com.bookiary.booking_books.domain.model.Location;
import com.bookiary.booking_books.infrastructure.repository.BookRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookPublisherService bookPublisherService;
    @Autowired
    private LocationService locationService;

    public Book newBook(NewBookDto dto) {
        Author author = authorService.createAuthor(dto.authorDto());
        BookPublisher bookPublisher = bookPublisherService.createBookPublisher(dto.bookPublisherDto());
        Location location = locationService.createLocation(dto.locationDto());
        Book book = new Book(
                dto.title(), dto.isbn(), author,
                bookPublisher, dto.publicationYear(), dto.category(),
                dto.quantityAvaible(), location);
        return bookRepository.save(book);
    }

    public Page<ListBooksDto> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable).map(ListBooksDto::new);
    }

    public Book updateData(UpdateDataDto dto) {
        var book = bookRepository.findById(dto.id())
                .orElseThrow(() -> new ValidationException("Book id doesn't is registered."));
        book.update(dto);
        return book;
    }

    public void deleteBook(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Book id doesn't is registered."));

        book.updateStatus();
    }
}
