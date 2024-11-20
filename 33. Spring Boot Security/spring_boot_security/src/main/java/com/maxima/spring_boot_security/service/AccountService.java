package com.maxima.spring_boot_security.service;

import com.maxima.spring_boot_security.dto.SignInForm;
import com.maxima.spring_boot_security.dto.SignUpForm;
import com.maxima.spring_boot_security.model.Account;

import java.util.List;

public interface AccountService {

    void saveAccount(SignUpForm signUpForm);

    Boolean signIn(SignInForm signInForm);

    List<Account> getAllAccounts();

    Account getById(Long id);

    void delete(Long id);
}
