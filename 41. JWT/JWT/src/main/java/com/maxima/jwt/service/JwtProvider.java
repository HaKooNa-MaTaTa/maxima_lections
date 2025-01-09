package com.maxima.jwt.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

//Генерация, валидация и извлечение данных из токена
@Component
public class JwtProvider {

    private static final String SECRET_KEY = "SECRET_KEY_for_TOKEN_1234567890_IS_VERY_BIG_KEY";

    private static final long EXPIRATION_MILLIS = 15 * 60 * 1000;

    //Генерируем токен
    public String generateToken(String username) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + EXPIRATION_MILLIS);

        SecretKey key = getSigningKey();

        return Jwts.builder()
            .subject(username)
            .issuedAt(now)
            .expiration(expireDate)
            .signWith(key)
            .compact();
    }

    private static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    //Валидируем
    public boolean validateToken(String token) {
        try {
            SecretKey key = getSigningKey();

            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token); //Если токен не корректен или просрочен, вылетит эксепшен

            return true;
        } catch (Exception e) {
            System.out.println("Invalid JWT token");
            return false;
        }
    }

    //Извлечь из токена логин пользователя
    public String getUsernameFromToken(String token) {
        SecretKey key = getSigningKey();
        Jws<Claims> claims = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token);

        return claims.getPayload().getSubject();
    }
}
