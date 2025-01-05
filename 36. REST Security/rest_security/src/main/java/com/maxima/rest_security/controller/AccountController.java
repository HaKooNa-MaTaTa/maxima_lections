package com.maxima.rest_security.controller;

import com.maxima.rest_security.dto.SignUpForm;
import com.maxima.rest_security.model.Account;
import com.maxima.rest_security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody SignUpForm form) {
        return ResponseEntity.ok(accountService.saveAccount(form));
    }

    @RequestMapping(value = "/{account_id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "account_id") Long id) {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @RequestMapping(value = "/{account_id}/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteAccountById(@PathVariable(value = "account_id") Long id) {
        accountService.delete(id);
        return ResponseEntity.ok().build();
    }

}
