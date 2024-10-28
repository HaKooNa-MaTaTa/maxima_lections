package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.config.ApplicationConfig;
import project.dto.SignUpForm;
import project.model.Account;
import project.service.AccountService;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ApplicationConfig.class);

        AccountService accountService = (AccountService) applicationContext.getBean("accountServiceJpa");
//        accountService.save(
//            SignUpForm.builder()
//                .email("oleg@mail.ru")
//                .firstName("Oleg")
//                .lastName("Igonin")
//                .password("Leopoldovich")
//                .build());

//        Account account = accountService.findById(1L);
//        accountService.deleteById(1L);

        List<Account> byLastName = accountService.findByLastName("Igonin");
        List<Account> byEmail = accountService.findByEmail("oleg@mail.ru");
        int i = 0;
    }
}
