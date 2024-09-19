package app.app;

import app.model.Account;
import app.security.ApplicationConfig;
import app.service.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnnotationSpring {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountServiceImpl");
        accountService.save(Account.builder()
            .id(2L)
            .firstName("Vladimir")
            .lastName("Igonin")
            .email("vladimir_igonin@mail.ru")
            .password("12345678910@#!")
            .build());

        System.out.println(accountService.getAfterInitializationField());
    }
}
