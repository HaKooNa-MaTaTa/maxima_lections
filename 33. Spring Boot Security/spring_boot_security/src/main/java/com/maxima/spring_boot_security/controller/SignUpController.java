package com.maxima.spring_boot_security.controller;

import com.maxima.spring_boot_security.dto.SignUpForm;
import com.maxima.spring_boot_security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final AccountService accountService;

    @Autowired
    public SignUpController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String getSignUpPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/profile";
        }
        return "signUp";
    }

    @PostMapping
    public String signUp(SignUpForm signUpForm) {
        accountService.saveAccount(signUpForm);
        return "redirect:/signIn";
    }
}
