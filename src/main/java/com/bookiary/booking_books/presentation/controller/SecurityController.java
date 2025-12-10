package com.bookiary.booking_books.presentation.controller;

import com.bookiary.booking_books.application.dto.request.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
@RequiredArgsConstructor
public class SecurityController {

    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<Void> login(LoginDto dto) {
        var token = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        var authentication = authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
