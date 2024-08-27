package app.validator;

import java.util.regex.Pattern;

public class EmailValidatorByCharacterImpl implements EmailValidator {

    private Pattern pattern;

    @Override
    public void validate(String email) {
        if (!pattern.matcher(email).find()) {
            throw new IllegalArgumentException("Email введен некорректно");
        }
    }

    public void setPattern(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }
}
