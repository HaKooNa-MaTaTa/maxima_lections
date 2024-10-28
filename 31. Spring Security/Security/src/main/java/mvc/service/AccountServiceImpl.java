package mvc.service;

import mvc.dto.AccountDto;
import mvc.model.Account;
import mvc.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveAccount(AccountDto accountDto) {
        Account account = Account.builder()
            .firstName(accountDto.getFirstName())
            .lastName(accountDto.getLastName())
            .email(accountDto.getEmail())
            .password(passwordEncoder.encode(accountDto.getPassword()))
            .role(accountDto.getRole())
            .state(accountDto.getState())
            .build();

        accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }
}
