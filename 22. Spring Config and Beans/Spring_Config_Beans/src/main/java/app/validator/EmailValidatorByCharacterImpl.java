package app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Primary //Данная аннотация указывает, что данный бин в приоритете перед другими
@Component("emailValByChar")
public class EmailValidatorByCharacterImpl implements EmailValidator {

    private Pattern pattern;

    @Override
    public void validate(String email) {
        if (!pattern.matcher(email).find()) {
            throw new IllegalArgumentException("Email введен некорректно");
        }
    }

    //@Value - аннотация, которая указывает, что в данный параметр нужно внедрить какое то значение
    @Autowired //Основная аннотация для inject`а зависимостей
    public void setPattern(@Value("${validator.email.regex}") String pattern) {
        this.pattern = Pattern.compile(pattern);
    }
}
