package app.app;

import app.model.Account;
import app.repository.AccountRepository;
import app.repository.AccountRepositoryInMemoryImpl;
import app.service.AccountService;
import app.service.AccountServiceImpl;
import app.validator.BlackListPassword;
import app.validator.BlackListPasswordInMemoryImpl;
import app.validator.EmailValidatorByCharacterImpl;
import app.validator.PasswordValidator;
import app.validator.PasswordValidatorByCharacterImpl;

public class Main {

    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepositoryInMemoryImpl();
        BlackListPassword blackListPassword = new BlackListPasswordInMemoryImpl();
        EmailValidatorByCharacterImpl emailValidator = new EmailValidatorByCharacterImpl();
        emailValidator.setPattern(".+@.+");
        PasswordValidator passwordValidator = new PasswordValidatorByCharacterImpl();

        AccountService accountService = new AccountServiceImpl(
            accountRepository,
            blackListPassword,
            emailValidator,
            passwordValidator
        );

        accountService.save(Account.builder()
            .id(1L)
            .firstName("Oleg")
            .lastName("Igonin")
            .email("oleg_igonin@mail.ru")
            .password("12345678910!")
            .build());
    }
}
