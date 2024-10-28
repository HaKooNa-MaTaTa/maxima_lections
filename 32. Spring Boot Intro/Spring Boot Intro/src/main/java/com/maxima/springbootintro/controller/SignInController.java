package com.maxima.springbootintro.controller;

import com.maxima.springbootintro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    private final AccountService accountService;

    @Autowired
    public SignInController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String getSignInPage() {
        return "signIn";
    }
}
