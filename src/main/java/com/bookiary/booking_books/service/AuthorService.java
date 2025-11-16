package com.bookiary.booking_books.service;

import com.bookiary.booking_books.dto.AuthorDto;
import com.bookiary.booking_books.model.Author;
import com.bookiary.booking_books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(AuthorDto dto) {
        return authorRepository.findByNameAndBirthDate(dto.name(), dto.birthDate())
                .orElseGet(() -> authorRepository.save(new Author(dto.name(), dto.birthDate(), dto.nationality())));
    }
}
