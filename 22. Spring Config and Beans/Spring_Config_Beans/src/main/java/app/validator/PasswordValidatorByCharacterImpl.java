package app.validator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("passValByChar")
public class PasswordValidatorByCharacterImpl implements PasswordValidator {

    @Override
    public void validate(String password) {
        if (password.indexOf('!') == -1 ||
            password.indexOf('@') == -1 ||
            password.indexOf('#') == -1) {
            throw new IllegalArgumentException("Пароль не содержит спецсимволы - !, @, #");
        }
    }
}
