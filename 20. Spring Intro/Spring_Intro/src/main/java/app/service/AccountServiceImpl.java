package app.service;

import app.model.Account;
import app.repository.AccountRepository;
import app.validator.BlackListPassword;
import app.validator.EmailValidator;
import app.validator.PasswordValidator;

/**
 * Сервис для работы с {@link Account}
 */
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final BlackListPassword blackListPassword;

    private final EmailValidator emailValidator;

    private final PasswordValidator passwordValidator;

    public AccountServiceImpl(AccountRepository accountRepository, BlackListPassword blackListPassword, EmailValidator emailValidator,
                              PasswordValidator passwordValidator) {
        this.accountRepository = accountRepository;
        this.blackListPassword = blackListPassword;
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    @Override
    public void save(Account account) {
        blackListPassword.contains(account.getPassword());
        emailValidator.validate(account.getEmail());
        passwordValidator.validate(account.getPassword());

        accountRepository.save(account);
    }
}
