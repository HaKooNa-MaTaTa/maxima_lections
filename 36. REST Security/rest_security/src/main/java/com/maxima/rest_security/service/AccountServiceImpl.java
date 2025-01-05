package com.maxima.rest_security.service;

import com.maxima.rest_security.dto.SignInForm;
import com.maxima.rest_security.dto.SignUpForm;
import com.maxima.rest_security.model.Account;
import com.maxima.rest_security.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account saveAccount(SignUpForm signUpForm) {
        Account account = Account.builder()
            .firstName(signUpForm.getFirstName())
            .lastName(signUpForm.getLastName())
            .email(signUpForm.getEmail())
            .password(passwordEncoder.encode(signUpForm.getPassword()))
            .role(Account.Role.USER)
            .state(Account.State.NOT_CONFIRMED)
            .build();

        return accountRepository.save(account);
    }

    @Override
    public Boolean signIn(SignInForm signInForm) {
        Account account = accountRepository.getByEmail(signInForm.getEmail());

        return account != null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
