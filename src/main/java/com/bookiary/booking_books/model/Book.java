package com.bookiary.booking_books.model;

import com.bookiary.booking_books.dto.UpdateDataDto;
import com.bookiary.booking_books.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String title;
    @Column(unique = true)
    private String isbn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_publisher_id")
    private BookPublisher bookPublisher;
    private Integer publicationYear;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Integer quantityAvaible;
    @Embedded
    private Location location;
    private boolean active;

    public Book (String title,
                String isbn,
                Author author,
                BookPublisher bookPublisher,
                Integer publicationYear,
                Category category,
                Integer quantityAvaible,
                Location location) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.bookPublisher = bookPublisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.quantityAvaible = quantityAvaible;
        this.location = location;
        this.active = true;
    }

    public void update(UpdateDataDto dto) {
        if(dto.avaibleQuantity() != null) {
            this.quantityAvaible = dto.avaibleQuantity();
        }

        if(dto.bookPublisherDto() != null) {
            this.bookPublisher.update(dto.bookPublisherDto());
        }

        if(dto.locationDto() != null) {
            this.location.update(dto.locationDto());
        }

    }

    public void updateStatus() {
        this.active = false;
    }
}
