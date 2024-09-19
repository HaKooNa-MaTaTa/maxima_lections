package app.validator;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Реализация {@link BlackListPassword}, InMemory
 */
//Данная аннотация ставится над классом, у которого есть какая то функциональность
// которая нам нужна в работе приложения.
@Component
public class BlackListPasswordInMemoryImpl implements BlackListPassword {

    private final List<String> badPasswords = new ArrayList<>(Arrays.asList("admin", "qwerty", "12345"));
    @Override
    public void contains(String password) {
        if (badPasswords.contains(password)) {
            throw new IllegalArgumentException("Ваш пароль - уже слит в интернет. Придумайте другой");
        }
    }
}
