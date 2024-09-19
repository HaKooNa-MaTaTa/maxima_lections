package app.security;

import app.repository.AccountRepository;
import app.service.AccountService;
import app.service.AccountServiceImpl;
import app.validator.BlackListPassword;
import app.validator.EmailValidator;
import app.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Конфигурационный класс приложения
 */
@Configuration //Данная аннотация указывает Spring`у, что в данном классе есть настройки приложения
@ComponentScan(basePackages = {"app"})//Мы указываем, что Spring`у нужно искать бины внутри папки app.
@PropertySource(value = "classpath:application.properties")
public class ApplicationConfig {

    //Разница между @Component и @Bean?
    //@Component ставится на классы, у которых простая инициализация.
    //@Bean ставится на метод, который создает, инициализирует и настраивает бин.
    //@Bean применяется для тех классов, у которых есть какая то настройка, перед созданием бина.
    @Bean(name = "accountServiceImpl")
    public AccountServiceImpl accountService(AccountRepository accountRepository,
                                         BlackListPassword blackListPassword,
                                         EmailValidator emailValidator,
                                         PasswordValidator passwordValidator) {
        AccountServiceImpl accountService = new AccountServiceImpl(accountRepository,
            blackListPassword,
            emailValidator,
            passwordValidator);

        accountService.setAfterInitializationField("Это поле мы инициализировали во время настройки объекта. Мы молодцы!");

        return accountService;
    }
}
