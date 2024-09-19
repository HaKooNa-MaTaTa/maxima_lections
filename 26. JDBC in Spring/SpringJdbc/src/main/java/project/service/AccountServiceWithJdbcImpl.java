package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dto.SignUpForm;
import project.model.Account;
import project.repository.AccountRepository;

@Service("accountService")
public class AccountServiceWithJdbcImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceWithJdbcImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void save(SignUpForm form) {
        //Может находиться какая-то дополнительная бизнес-логика
        accountRepository.save(form);
    }

    @Override
    public Account findById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        accountRepository.deleteById(id);
    }
}
