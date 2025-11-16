package com.bookiary.booking_books.service;

import com.bookiary.booking_books.dto.ListBooksDto;
import com.bookiary.booking_books.dto.NewBookDto;
import com.bookiary.booking_books.dto.UpdateDataDto;
import com.bookiary.booking_books.model.Author;
import com.bookiary.booking_books.model.Book;
import com.bookiary.booking_books.model.BookPublisher;
import com.bookiary.booking_books.model.Location;
import com.bookiary.booking_books.repository.BookRepository;
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

    public void newBook(NewBookDto dto) {
        Author author = authorService.createAuthor(dto.authorDto());
        BookPublisher bookPublisher = bookPublisherService.createBookPublisher(dto.bookPublisherDto());
        Location location = locationService.createLocation(dto.locationDto());
        Book book = new Book(
                dto.title(), dto.isbn(), author,
                bookPublisher, dto.publicationYear(), dto.category(),
                dto.quantityAvaible(), location);
        bookRepository.save(book);
    }

    public Page<ListBooksDto> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable).map(ListBooksDto::new);
    }

    public void updateData(UpdateDataDto dto) {
        var book = bookRepository.findById(dto.id())
                .orElseThrow(() -> new ValidationException("Book id doesn't is registered."));
        book.update(dto);
    }

    public void deleteBook(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Book id doesn't is registered."));

        book.updateStatus();
    }
}
