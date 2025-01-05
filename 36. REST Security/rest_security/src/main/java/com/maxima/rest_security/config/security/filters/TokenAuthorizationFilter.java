package com.maxima.rest_security.config.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxima.rest_security.config.security.user_details.AccountUserDetails;
import com.maxima.rest_security.model.Account;
import com.maxima.rest_security.repository.AccountRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
public class TokenAuthorizationFilter extends OncePerRequestFilter {

    private final AccountRepository accountRepository;
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {
        if (request.getRequestURI().equals("/api/login")) {
            filterChain.doFilter(request, response);
        } else {
            //"Bearer alskdjgalsgjluj124isdkgj9i0upodsjg0i9dufg"
            String tokenHeader = request.getHeader("Authorization");
            if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
                String token = tokenHeader.substring("Bearer ".length());

                //
                Optional<Account> account = accountRepository.findByToken(token);

                if (account.isPresent()) {
                    AccountUserDetails userDetails = new AccountUserDetails(account.get());
                    UsernamePasswordAuthenticationToken usPassToken =
                        new UsernamePasswordAuthenticationToken(token, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(usPassToken);

                    filterChain.doFilter(request, response);
                } else {
                    logger.warn("Wrong token");
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    objectMapper.writeValue(
                        response.getWriter(),
                        Collections.singletonMap("error", "user not found with token")
                    );
                }
            } else {
                logger.warn("Token is missing");
                filterChain.doFilter(request, response);
            }
        }
    }
}
