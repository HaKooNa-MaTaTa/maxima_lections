package com.maxima.jwt.service;

import com.maxima.jwt.enums.TokenType;
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
//    private static final String REFRESH_SECRET_KEY = "REFRESH_SECRET_KEY_for_TOKEN_1234567890_IS_VERY_BIG_KEY";

    private static final long ACCESS_EXPIRES_MILLIS = 15 * 60 * 1000; //15 минут
    private static final long REFRESH_EXPIRES_MILLIS = 24 * 60 * 60 * 1000; //1 день

    //Генерация access токена
    public String generateAccessToken(String username) {
        return generateToken(username, TokenType.ACCESS, ACCESS_EXPIRES_MILLIS);
    }

    //Генерация refresh токена
    public String generateRefreshToken(String username) {
        return generateToken(username, TokenType.REFRESH, REFRESH_EXPIRES_MILLIS);
    }

    //Генерируем токен
    private String generateToken(String username, TokenType type, long expires) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + expires);

        SecretKey key = getSigningKey();

        return Jwts.builder()
            .subject(username)
            .claim("tokenType", type.name())
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
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public String getTokenType(String token) {
        return (String) getClaims(token).get("tokenType");
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
}
