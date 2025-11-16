package com.bookiary.booking_books.domain.model;

import com.bookiary.booking_books.application.dto.LocationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Location {
    private String section;
    private String bookShelf;
    private String shelf;

    public Location(LocationDto locationDto) {
        this.section = locationDto.section();
        this.bookShelf = locationDto.bookShelf();
        this.shelf = locationDto.shelf();
    }

    public void update(LocationDto bookPublisherDto) {
        this.section = bookPublisherDto.section();
        this.bookShelf = bookPublisherDto.bookShelf();
        this.shelf = bookPublisherDto.shelf();
    }
}
