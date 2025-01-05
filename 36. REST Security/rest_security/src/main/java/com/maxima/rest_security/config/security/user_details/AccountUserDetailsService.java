package com.maxima.rest_security.config.security.user_details;

import com.maxima.rest_security.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //Как найти нашего пользователя, если мы знаем его email?
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AccountUserDetails(accountRepository.getByEmail(email));
    }
}
