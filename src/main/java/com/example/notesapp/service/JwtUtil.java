package com.example.notesapp.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private static final SecretKey secretKey = Keys.hmacShaKeyFor(
            "this-is-a-placeholder-dev-secret-key-change-me-32-bytes-min".getBytes()
    );

    private static final long expiration_ms = 1000 * 60 * 60; // 1 hour

    public String generateToken(String username) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expiration_ms);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
