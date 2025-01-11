package com.maxima.jwt.controller;

import com.maxima.jwt.dto.request.AuthRequest;
import com.maxima.jwt.dto.request.TokenRefreshRequest;
import com.maxima.jwt.dto.response.AuthResponse;
import com.maxima.jwt.dto.response.TokenRefreshResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InnerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void successfulFullFlow() {
        //Удачно залогинимся
        AuthRequest authRequest = new AuthRequest("postgres", "postgres");
        String loginUrl = "http://localhost:" + port + "/auth/login";
        ResponseEntity<AuthResponse> loginResponse = restTemplate.postForEntity(
          loginUrl, authRequest, AuthResponse.class
        );
        assertEquals(HttpStatus.OK, loginResponse.getStatusCode());
        assertNotNull(loginResponse.getBody());

        String accessToken = loginResponse.getBody().getAccessToken();
        String refreshToken = loginResponse.getBody().getRefreshToken();

        //Попадем на защищенный эндпоинт
        String secureUrl = "http://localhost:" + port + "/api/hello";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> protectedResponse = restTemplate.exchange(
            secureUrl, HttpMethod.GET, entity, String.class
        );

        assertEquals(HttpStatus.OK, protectedResponse.getStatusCode());
        assertEquals("Hello World!", protectedResponse.getBody());

        //Поменяем access токен с помощью refresh токена
        String refreshUrl = "http://localhost:" + port + "/auth/refresh";
        HttpEntity<TokenRefreshRequest> refreshEntity = new HttpEntity<>(new TokenRefreshRequest(refreshToken));
        ResponseEntity<TokenRefreshResponse> refreshResponse = restTemplate.exchange(
            refreshUrl, HttpMethod.POST, refreshEntity, TokenRefreshResponse.class
        );

        assertEquals(HttpStatus.OK, refreshResponse.getStatusCode());
        assertNotNull(refreshResponse.getBody());
        String newAccessToken = refreshResponse.getBody().getAccessToken();
        assertNotNull(newAccessToken);

        //Попадем на защищенный эндпоинт c новым access токеном
        headers.clear();
        headers.set("Authorization", "Bearer " + newAccessToken);
        entity = new HttpEntity<>(headers);

        ResponseEntity<String> secureResponse = restTemplate.exchange(
          secureUrl, HttpMethod.GET, entity, String.class
        );

        assertEquals(HttpStatus.OK, secureResponse.getStatusCode());
        assertEquals("Hello World!", secureResponse.getBody());
    }
}
