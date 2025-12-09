package com.bookiary.booking_books.presentation.exception;

import com.bookiary.booking_books.application.dto.response.ErrorsFieldDto;
import com.bookiary.booking_books.application.dto.response.ExceptionDto;
import com.bookiary.booking_books.application.dto.response.GenericExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<GenericExceptionDto> notFound(EntityNotFoundException e) {
        return new ResponseEntity<>(new GenericExceptionDto("4004", "Book Not Found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> badRequest(MethodArgumentNotValidException e) {
        List<ErrorsFieldDto> erros = e.getBindingResult()
                .getFieldErrors().stream().map(error ->
                        new ErrorsFieldDto(error.getField(), error.getDefaultMessage())).toList();

        ExceptionDto error = new ExceptionDto("4000", "Valdation Failed", erros);
        return ResponseEntity.badRequest().body(error);
    }
}
