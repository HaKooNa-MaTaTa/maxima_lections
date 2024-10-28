package com.maxima.springbootintro.controller;

import com.maxima.springbootintro.dto.SignUpForm;
import com.maxima.springbootintro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfFilter;
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
    public String getSignUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    @PostMapping
    public String signUp(SignUpForm signUpForm) {
        accountService.saveAccount(signUpForm);
        return "redirect:/signIn";
    }
}
