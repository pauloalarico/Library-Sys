package com.bookiary.booking_books.application.service;

import com.bookiary.booking_books.application.dto.BookPublisherDto;
import com.bookiary.booking_books.domain.model.BookPublisher;
import com.bookiary.booking_books.infrastructure.repository.BookPublisherRepository;
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
