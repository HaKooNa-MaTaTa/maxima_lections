package com.maxima.rest_security.service;


import com.maxima.rest_security.dto.SignInForm;
import com.maxima.rest_security.dto.SignUpForm;
import com.maxima.rest_security.model.Account;

import java.util.List;

public interface AccountService {

    Account saveAccount(SignUpForm signUpForm);

    Boolean signIn(SignInForm signInForm);

    List<Account> getAllAccounts();

    Account getById(Long id);

    void delete(Long id);
}
