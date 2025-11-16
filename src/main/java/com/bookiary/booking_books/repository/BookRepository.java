package com.bookiary.booking_books.repository;

import com.bookiary.booking_books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository <Book, Long> {

    Optional<Book> findById(Long id);
}
