package app.service;

import app.dto.AccountDto;
import app.model.Account;
import app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void signUp(AccountDto dto) {
        accountRepository.signUp(
            Account.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
    }

    @Override
    public List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.getAll();
        return accounts.stream()
            .map(acc -> AccountDto.builder()
                .firstName(acc.getFirstName())
                .lastName(acc.getLastName())
                .email(acc.getEmail())
                .password(acc.getPassword())
                .build())
            .collect(Collectors.toList());
    }
}
