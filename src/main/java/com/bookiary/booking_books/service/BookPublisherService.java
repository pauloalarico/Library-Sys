package com.bookiary.booking_books.service;

import com.bookiary.booking_books.dto.BookPublisherDto;
import com.bookiary.booking_books.model.BookPublisher;
import com.bookiary.booking_books.repository.BookPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookPublisherService {
    @Autowired
    private BookPublisherRepository bookPublisherRepository;

    public BookPublisher createBookPublisher(BookPublisherDto dto) {
        return bookPublisherRepository.findByNameAndFoundationYear(dto.name(), dto.foundationYear())
                .orElseGet(() -> bookPublisherRepository.save(new BookPublisher(dto.name(), dto.foundationYear())));
    }
}
