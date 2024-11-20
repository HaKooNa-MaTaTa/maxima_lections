package com.maxima.spring_boot_security.controller;

import com.maxima.spring_boot_security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping
    public String getAllAccounts(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());

        return "accounts";
    }

    @RequestMapping(value = "/{account_id}", method = RequestMethod.GET)
    public String getAccountById(Model model, @PathVariable(value = "account_id") Long id) {
        model.addAttribute("account", accountService.getById(id));

        return "account";
    }

    @RequestMapping(value = "/{account_id}/delete", method = RequestMethod.POST)
    public String deleteAccountById(@PathVariable(value = "account_id") Long id) {
        accountService.delete(id);
        return "redirect:/accounts";
    }

}
