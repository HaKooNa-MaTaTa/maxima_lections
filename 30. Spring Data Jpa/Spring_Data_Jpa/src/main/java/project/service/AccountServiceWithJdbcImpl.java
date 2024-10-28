package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dto.SignUpForm;
import project.model.Account;
import project.repository.old_version.AccountRepository;

import java.util.List;

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
    public Account findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<Account> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Account> findByEmail(String email) {
        return null;
    }
}
