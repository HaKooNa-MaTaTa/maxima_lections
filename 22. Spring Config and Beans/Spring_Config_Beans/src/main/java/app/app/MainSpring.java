package app.app;

import app.model.Account;
import app.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

    public static void main(String[] args) {

        //Это - контейнер бинов (IoC-контейнер). Здесь хранятся абсолютно все бины, которые создаются в рамках
        //работы приложения. Вокруг этого контейнера построен Spring.
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.save(Account.builder()
            .id(2L)
            .firstName("Vladimir")
            .lastName("Igonin")
            .email("vladimir_igonin@mail.ru")
            .password("12345678910@#!")
            .build());
    }
}
