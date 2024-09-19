package app.service;

import app.model.Account;
import app.repository.AccountRepository;
import app.validator.BlackListPassword;
import app.validator.EmailValidator;
import app.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * Сервис для работы с {@link Account}
 */
//Данная аннотация, указывает на то, что данный класс содержит внутри себя
//некую бизнес логику. Spring создаст бин на основе этого класса.
public class AccountServiceImpl implements AccountService {

    private String afterInitializationField;
    private final AccountRepository accountRepository;

    private final BlackListPassword blackListPassword;

    private final EmailValidator emailValidator;

    private final PasswordValidator passwordValidator;

    @PostConstruct //Ставится на метод, который должен быть выполнен после инициализация бина
    private void init() {
        setAfterInitializationField("А здесь мы в методе init()");
    }

    //TODO: Посмотреть, почему не сработал
    @PreDestroy
    private void preDestroy() {
        System.out.println("Бину Spring`a - конец!");
    }

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              BlackListPassword blackListPassword,
                              @Qualifier("emailValByLength") EmailValidator emailValidator,
                              @Qualifier("passValByLength") PasswordValidator passwordValidator) {
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

    public String getAfterInitializationField() {
        return afterInitializationField;
    }

    public void setAfterInitializationField(String afterInitializationField) {
        this.afterInitializationField = afterInitializationField;
    }
}
