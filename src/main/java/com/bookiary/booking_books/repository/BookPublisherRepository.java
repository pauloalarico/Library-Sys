package com.bookiary.booking_books.repository;

import com.bookiary.booking_books.model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Long> {
    Optional<BookPublisher> findByNameAndFoundationYear(String name, Integer foundationYear);
}
