package com.maxima.springbootintro.service;

import com.maxima.springbootintro.dto.SignUpForm;
import com.maxima.springbootintro.model.Account;
import com.maxima.springbootintro.repository.AccountRepository;
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
    public void saveAccount(SignUpForm signUpForm) {
        Account account = Account.builder()
            .firstName(signUpForm.getFirstName())
            .lastName(signUpForm.getLastName())
            .email(signUpForm.getEmail())
            .password(passwordEncoder.encode(signUpForm.getPassword()))
            .role(Account.Role.USER)
            .state(Account.State.NOT_CONFIRMED)
            .build();

        accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
