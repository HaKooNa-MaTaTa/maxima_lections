package app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("passValByLength")
public class PasswordValidatorByLengthImpl implements PasswordValidator {

    private final int minLength;

    @Autowired
    public PasswordValidatorByLengthImpl(@Value("${validator.password.min-length}") int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void validate(String password) {
        if (password.length() < minLength) {
            throw new IllegalArgumentException("Пароль слишком короткий");
        }
    }
}
