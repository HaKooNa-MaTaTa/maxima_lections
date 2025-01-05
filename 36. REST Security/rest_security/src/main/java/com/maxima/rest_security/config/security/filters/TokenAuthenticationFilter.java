package com.maxima.rest_security.config.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxima.rest_security.config.security.user_details.AccountUserDetails;
import com.maxima.rest_security.dto.SignInForm;
import com.maxima.rest_security.model.Account;
import com.maxima.rest_security.repository.AccountRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;
    private final AccountRepository accountRepository;

    public TokenAuthenticationFilter(
        AuthenticationManager authenticationManager,
        ObjectMapper objectMapper,
        AccountRepository accountRepository
    ) {
        super(authenticationManager);
        this.objectMapper = objectMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            SignInForm form = objectMapper.readValue(request.getReader(), SignInForm.class);
            UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword());

            return super.getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain,
        Authentication authResult
    ) throws IOException {

        AccountUserDetails accountUserDetails = (AccountUserDetails) authResult.getPrincipal();
        Account account = accountUserDetails.getAccount();
        String token = UUID.randomUUID().toString();
        account.setToken(token);
        accountRepository.save(account);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.writeValue(response.getWriter(), Collections.singletonMap("token", token));
    }
}
