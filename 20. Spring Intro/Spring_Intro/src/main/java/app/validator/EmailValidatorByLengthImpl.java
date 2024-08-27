package app.validator;

public class EmailValidatorByLengthImpl implements EmailValidator {

    private final int minLength;

    public EmailValidatorByLengthImpl(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void validate(String email) {
        if (email.length() < minLength) {
            throw new IllegalArgumentException("Email слишком короткий.");
        }
    }
}
