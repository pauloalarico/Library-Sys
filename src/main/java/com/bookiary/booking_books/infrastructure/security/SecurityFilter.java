package com.bookiary.booking_books.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter  {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request,response);
    }

    private String tokenRecovery(HttpServletRequest request) {
        var header = request.getHeader("Authorization");
        if (header.contentEquals(header)) {
            throw new RuntimeException("Token invalid!");
        }
        return header.replace("Bearer: ", "");
    }
}
