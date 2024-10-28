package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dto.SignUpForm;
import project.model.Account;
import project.repository.new_version.AccountJpaRepository;

import java.util.List;
import java.util.Optional;

@Service("accountServiceJpa")
public class AccountServiceWithJpaImpl implements AccountService {

    private final AccountJpaRepository accountJpaRepository;

    @Autowired
    public AccountServiceWithJpaImpl(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public void save(SignUpForm form) {
        Account account = Account.builder()
            .firstName(form.getFirstName())
            .lastName(form.getLastName())
            .email(form.getEmail())
            .password(form.getPassword())
            .build();
        account = accountJpaRepository.save(account);
        int i = 0;
    }

    @Override
    public Account findById(Long id) {
        Optional<Account> acc = accountJpaRepository.findById(id);
        if (acc.isPresent()) {
            return acc.get();
        }

        throw new RuntimeException("Пользователь с таким id не найден");
    }

    @Override
    public void deleteById(Long id) {
        accountJpaRepository.deleteById(id);
    }

    @Override
    public List<Account> findByLastName(String lastName) {
        return accountJpaRepository.fBLN(lastName);
    }

    @Override
    public List<Account> findByEmail(String email) {
        return accountJpaRepository.fBE(email);
    }
}
