package com.maxima.rest_security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxima.rest_security.config.security.filters.TokenAuthenticationFilter;
import com.maxima.rest_security.config.security.filters.TokenAuthorizationFilter;
import com.maxima.rest_security.config.security.user_details.AccountUserDetailsService;
import com.maxima.rest_security.repository.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@ComponentScan(basePackages = "com.maxima.rest_security")
@EnableWebSecurity
public class ApplicationConfig {

    private final AccountUserDetailsService accountUserDetailsService;
    private final ObjectMapper objectMapper;
    private final AccountRepository accountRepository;

    public ApplicationConfig(
        AccountUserDetailsService accountUserDetailsService,
        ObjectMapper objectMapper,
        AccountRepository accountRepository
    ) {
        this.accountUserDetailsService = accountUserDetailsService;
        this.objectMapper = objectMapper;
        this.accountRepository = accountRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationConfiguration configuration) throws Exception {
        TokenAuthenticationFilter tokenAuthenticationFilter = new TokenAuthenticationFilter(
            authenticationManager(configuration),
            objectMapper,
            accountRepository
        );

        tokenAuthenticationFilter.setFilterProcessesUrl("/api/login");

        return http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(req ->
                req.requestMatchers("/api/login/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/accounts").authenticated()
                    .requestMatchers(HttpMethod.POST, "/accounts").hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/accounts/**").hasAuthority("ADMIN")
            )
            .formLogin(AbstractHttpConfigurer::disable)
            .addFilter(tokenAuthenticationFilter)
            .addFilterBefore(new TokenAuthorizationFilter(accountRepository, objectMapper),
                UsernamePasswordAuthenticationFilter.class)
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
        try {
            return configuration.getAuthenticationManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(accountUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
//    public void configure(AuthenticationManagerBuilder auth) {
//        try {
//            auth.userDetailsService(accountUserDetailsService).passwordEncoder(passwordEncoder());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
