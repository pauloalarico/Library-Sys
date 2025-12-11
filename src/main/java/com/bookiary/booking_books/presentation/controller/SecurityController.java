package com.bookiary.booking_books.presentation.controller;

import com.bookiary.booking_books.application.dto.request.LoginDto;
import com.bookiary.booking_books.application.dto.response.TokenDto;
import com.bookiary.booking_books.application.service.TokenService;
import com.bookiary.booking_books.domain.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SecurityController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody @Valid LoginDto dto) {
        var token = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        var authentication = authenticationManager.authenticate(token);
        var generatedToken = tokenService.createToken((User)  authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDto(dto.username(), generatedToken));
    }
}
