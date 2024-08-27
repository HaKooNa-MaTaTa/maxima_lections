package app.validator;

public class PasswordValidatorByLengthImpl implements PasswordValidator {

    private final int minLength;

    public PasswordValidatorByLengthImpl(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void validate(String password) {
        if (password.length() < minLength) {
            throw new IllegalArgumentException("Пароль слишком короткий");
        }
    }
}
