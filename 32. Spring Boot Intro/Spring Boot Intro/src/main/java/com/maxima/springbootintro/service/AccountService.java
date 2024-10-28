package com.maxima.springbootintro.service;

import com.maxima.springbootintro.dto.SignUpForm;
import com.maxima.springbootintro.model.Account;

import java.util.List;

public interface AccountService {

    void saveAccount(SignUpForm signUpForm);

    List<Account> getAllAccounts();
}
