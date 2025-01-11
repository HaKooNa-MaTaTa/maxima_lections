package com.maxima.jwt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxima.jwt.config.SecurityConfig;
import com.maxima.jwt.dto.request.AuthRequest;
import com.maxima.jwt.dto.request.TokenRefreshRequest;
import com.maxima.jwt.model.UserEntity;
import com.maxima.jwt.service.JwtProvider;
import com.maxima.jwt.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@Import(SecurityConfig.class)
public class AuthControllerWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @MockitoBean
    private JwtProvider jwtProvider;

    @Autowired
    private ObjectMapper objectMapper;

    //Удачный логин
    @Test
    void successfulLogin() throws Exception {
        UserEntity userEntity = new UserEntity(
            null,
            "postgres",
            "postgres",
            null
        );
        //Настройка поведения сервисов
        when(userService.findByUsername("postgres")).thenReturn(userEntity);
        when(jwtProvider.generateAccessToken(anyString())).thenReturn("accessToken");
        when(jwtProvider.generateRefreshToken(anyString())).thenReturn("refreshToken");

        AuthRequest authRequest = new AuthRequest("postgres", "postgres");
        String json = objectMapper.writeValueAsString(authRequest);

        mockMvc.perform(post("/auth/login")
            .contentType("application/json")
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.accessToken").value("accessToken"))
            .andExpect(jsonPath("$.refreshToken").value("refreshToken"));

    }

    //Неудачный логин - не найден пользователь
    @Test
    void failedLogin_userNotFound() throws Exception {
        //Настройка поведения сервисов
        when(userService.findByUsername(anyString())).thenReturn(null);

        AuthRequest authRequest = new AuthRequest("postgres", "postgres");
        String json = objectMapper.writeValueAsString(authRequest);

        mockMvc.perform(post("/auth/login")
                .contentType("application/json")
                .content(json))
            .andExpect(status().isUnauthorized());
    }

    //Удачный рефреш
    @Test
    void successfulRefreshToken() throws Exception {
        //Настраиваем поведение провайдера
        when(jwtProvider.validateToken("validateRefreshToken")).thenReturn(true);
        when(jwtProvider.getTokenType("validateRefreshToken")).thenReturn("REFRESH");
        when(jwtProvider.getUsername("validateRefreshToken")).thenReturn("postgres");
        when(jwtProvider.generateAccessToken("postgres")).thenReturn("validateAccessToken");

        TokenRefreshRequest tokenRefreshRequest = new TokenRefreshRequest("validateRefreshToken");
        String json = objectMapper.writeValueAsString(tokenRefreshRequest);

        mockMvc.perform(post("/auth/refresh")
            .contentType("application/json")
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.accessToken").value("validateAccessToken"));
    }

    //Неудачный рефреш
    @Test
    void failedRefreshToken_tokenInvalid() throws Exception {
        //Настраиваем поведение провайдера
        when(jwtProvider.validateToken("invalidRefreshToken")).thenReturn(false);

        TokenRefreshRequest tokenRefreshRequest = new TokenRefreshRequest("invalidRefreshToken");
        String json = objectMapper.writeValueAsString(tokenRefreshRequest);

        mockMvc.perform(post("/auth/refresh")
                .contentType("application/json")
                .content(json))
            .andExpect(status().isUnauthorized());
    }
}
