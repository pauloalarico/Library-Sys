package com.bookiary.booking_books.domain.model;

import com.bookiary.booking_books.application.dto.request.BookPublisherDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class BookPublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private Integer foundationYear;



    public BookPublisher(String name, Integer foundationYear) {
        this.name = name;
        this.foundationYear = foundationYear;
    }

    public void update(BookPublisherDto bookPublisherDto) {
        this.name = bookPublisherDto.name();
        this.foundationYear = bookPublisherDto.foundationYear();
    }
}
