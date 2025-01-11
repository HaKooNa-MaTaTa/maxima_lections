package com.maxima.jwt.controller;

import com.maxima.jwt.dto.request.AuthRequest;
import com.maxima.jwt.dto.request.TokenRefreshRequest;
import com.maxima.jwt.dto.response.AuthResponse;
import com.maxima.jwt.dto.response.TokenRefreshResponse;
import com.maxima.jwt.enums.TokenType;
import com.maxima.jwt.model.UserEntity;
import com.maxima.jwt.service.JwtProvider;
import com.maxima.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Autowired
    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        UserEntity user = userService.findByUsername(request.getUsername());

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        return ResponseEntity.ok(
            new AuthResponse(
                jwtProvider.generateAccessToken(request.getUsername()),
                jwtProvider.generateRefreshToken(request.getUsername())
            )
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody TokenRefreshRequest request) {
        String refreshToken = request.getRefreshToken();

        //Проверяем валидность рефреш токена
        if (!jwtProvider.validateToken(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalidate refresh token");
        }

        //Что токен действительно типа РЕФРЕШ
        if (!TokenType.REFRESH.name().equals(jwtProvider.getTokenType(refreshToken))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not a refresh token");
        }

        String newAccessToken = jwtProvider.generateAccessToken(jwtProvider.getUsername(refreshToken));
        return ResponseEntity.ok(new TokenRefreshResponse(newAccessToken));
    }
}
