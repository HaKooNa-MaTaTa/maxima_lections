package com.maxima.spring_boot_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@ComponentScan(basePackages = "com.maxima.spring_boot_security")
@EnableWebMvc
@EnableWebSecurity
public class ApplicationConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(req ->
                req.requestMatchers("/signUp").permitAll()
                    .requestMatchers("/signIn").permitAll()
                    .requestMatchers("/accounts/**").hasAuthority("ADMIN")
                    .requestMatchers("/profile").authenticated())
            .formLogin(log -> log.loginPage("/signIn")
                .usernameParameter("email")
                .passwordParameter("password")
                .successForwardUrl("/profile")
                .failureForwardUrl("/signIn?error")
                .permitAll())
            .build();
    }

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver fm = new FreeMarkerViewResolver();
        fm.setPrefix("");
        fm.setSuffix(".ftlh");
        fm.setContentType("text/html;charset=UTF-8");
        return fm;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates/");
        return freeMarkerConfigurer;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
