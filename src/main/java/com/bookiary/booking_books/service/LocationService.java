package com.bookiary.booking_books.service;

import com.bookiary.booking_books.dto.LocationDto;
import com.bookiary.booking_books.model.Location;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    public Location createLocation(LocationDto dto) {
        return new Location(dto);
    }
}
