package com.maxima.spring_boot_security.controller;

import com.maxima.spring_boot_security.dto.SignInForm;
import com.maxima.spring_boot_security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    private final AccountService accountService;

    @Autowired
    public SignInController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String getSignInPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/profile";
        }
        return "signIn";
    }

    @PostMapping
    public String signIn(SignInForm signInForm) {
        if (accountService.signIn(signInForm)) {
            return "redirect:/profile";
        } else {
            return "redirect:/signIn?error";
        }
    }
}
