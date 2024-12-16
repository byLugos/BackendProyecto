package com.example.demo.infraestructure.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final byte[] secretKey;

    public JwtUtil() {
        this.secretKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmno".getBytes();
    }

    public String generateToken(String email) {
        try {
            return Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al generar el token JWT", e);
        }
    }

    public String extractEmail(String token) {
        try {
            return extractClaim(token, Claims::getSubject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isTokenValid(String token, String email) {
        try {
            String extractedEmail = extractEmail(token);
            boolean isExpired = isTokenExpired(token);
            return email.equals(extractedEmail) && !isExpired;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }
}
