package com.bookiary.booking_books.presentation.controller;

import com.bookiary.booking_books.application.dto.request.ListBooksDto;
import com.bookiary.booking_books.application.dto.request.NewBookDto;
import com.bookiary.booking_books.application.dto.request.UpdateDataDto;
import com.bookiary.booking_books.application.dto.response.DataBookDto;
import com.bookiary.booking_books.application.service.BookService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/new")
    public ResponseEntity<DataBookDto> newBook (@RequestBody @Valid         NewBookDto dto,
                                                UriComponentsBuilder uriComponentsBuilder) {
        var book = bookService.newBook(dto);
        var uri = uriComponentsBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataBookDto(book));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<ListBooksDto>> getBooks(@PageableDefault(size = 10, sort = {"title"})Pageable pageable) {
        var page = bookService.getBooks(pageable);
        return ResponseEntity.ok(page);
    }

    @PatchMapping("/update")
    @Transactional
    public ResponseEntity<DataBookDto> updateBook(@RequestBody @Valid UpdateDataDto dto) {
        var book = bookService.updateData(dto);
        return ResponseEntity.ok(new DataBookDto(book));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
