package com.maxima.springbootintro.controller;

import com.maxima.springbootintro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


}
