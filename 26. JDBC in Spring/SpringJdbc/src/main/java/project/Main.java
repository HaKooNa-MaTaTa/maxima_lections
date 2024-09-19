package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.config.ApplicationConfig;
import project.dto.SignUpForm;
import project.model.Account;
import project.service.AccountService;


public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ApplicationConfig.class);

        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.save(
            SignUpForm.builder()
                .age(28)
                .email("oleg@mail.ru")
                .firstName("Oleg")
                .lastName("Igonin")
                .patronymic("Leopoldovich")
                .build());

        Account account = accountService.findById("e0fa6d46-c7c8-4eca-8438-e00c6cf6c763");
        accountService.deleteById("e0fa6d46-c7c8-4eca-8438-e00c6cf6c763");
        int i = 0;
    }
}
