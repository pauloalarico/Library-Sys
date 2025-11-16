package com.bookiary.booking_books.application.service;

import com.bookiary.booking_books.application.dto.LocationDto;
import com.bookiary.booking_books.domain.model.Location;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    public Location createLocation(LocationDto dto) {
        return new Location(dto);
    }
}
