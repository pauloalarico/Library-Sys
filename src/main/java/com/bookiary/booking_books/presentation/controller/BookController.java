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

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/new")
    public ResponseEntity<DataBookDto> newBook (@RequestBody @Valid NewBookDto dto) {
        var book = bookService.newBook(dto);
        return ResponseEntity.accepted().body(new DataBookDto(book));
    }

    @GetMapping("/list")
    public Page<ListBooksDto> getBooks(@PageableDefault(size = 10, sort = {"title"})Pageable pageable) {
        return bookService.getBooks(pageable);
    }

    @PatchMapping("/update")
    @Transactional
    public void updateBook(@RequestBody @Valid UpdateDataDto dto) {
        bookService.updateData(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
