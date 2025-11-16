package com.bookiary.booking_books.controller;

import com.bookiary.booking_books.dto.IdDto;
import com.bookiary.booking_books.dto.ListBooksDto;
import com.bookiary.booking_books.dto.NewBookDto;
import com.bookiary.booking_books.dto.UpdateDataDto;
import com.bookiary.booking_books.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/new")
    public void newBook (@RequestBody @Valid NewBookDto dto) {
        bookService.newBook(dto);
    }

    @GetMapping("/list")
    public Page<ListBooksDto> getBooks(@PageableDefault(size = 10, sort = {"title"})Pageable pageable) {
        return bookService.getBooks(pageable);
    }

    @PatchMapping("/update")
    public void updateBook(@RequestBody @Valid UpdateDataDto dto) {
        bookService.updateData(dto);
    }

    @PostMapping("/inactivate")
    public void deleteBook(@RequestBody @Valid IdDto dto) {
        bookService.deleteBook(dto);
    }
}
