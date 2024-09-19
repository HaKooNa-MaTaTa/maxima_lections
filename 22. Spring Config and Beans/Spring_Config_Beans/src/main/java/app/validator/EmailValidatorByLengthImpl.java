package app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emailValByLength")
public class EmailValidatorByLengthImpl implements EmailValidator {

    private final int minLength;

    //Когда в классе всего один конструктор, то к нему автоматически
    //проставляется аннотация @Autowired
    @Autowired
    public EmailValidatorByLengthImpl(@Value("${validator.email.min-length}") int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void validate(String email) {
        if (email.length() < minLength) {
            throw new IllegalArgumentException("Email слишком короткий.");
        }
    }
}
