package com.bookiary.booking_books.infrastructure.security;

import com.bookiary.booking_books.application.service.TokenService;
import com.bookiary.booking_books.infrastructure.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter  {

    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = tokenRecovery(request);
        var validate = tokenService.validate(token);
        var user = userRepository.findByUsername(validate);
        var authentication =  new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        filterChain.doFilter(request,response);
    }

    private String tokenRecovery(HttpServletRequest request) {
        var header = request.getHeader("Authorization");
        if (header == null) {
            throw new RuntimeException("Invalid token, or expired!");
        }
        return header.replace("Bearer: ", "");
    }
}
