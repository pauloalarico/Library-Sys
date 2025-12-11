package com.bookiary.booking_books.application.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.bookiary.booking_books.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${application.token.secret}")
    private String secretToken;

    public String createToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretToken);
            return JWT.create()
                    .withIssuer("booking-b0Oks")
                    .withSubject(user.getUsername())
                    .withExpiresAt(expirationPlusOneHour())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Invalid credentials!");
        }
    }


    public String validate(String tokenJwt) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretToken);
            return JWT.require(algorithm)
                    .withIssuer("booking-b0Oks")
                    .build()
                    .verify(tokenJwt)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Invalid Token or Expirated");
        }
    }

    private Instant expirationPlusOneHour() {
        return Instant.now().plusSeconds(7200);
    }

}
