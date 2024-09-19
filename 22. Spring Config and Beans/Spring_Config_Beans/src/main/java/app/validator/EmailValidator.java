package app.validator;

/**
 * Интерфейс сервиса, который будет валидировать email пользователя
 */
public interface EmailValidator {

    /**
     * Метод, который проверяет корректность переденного email
     * @param email почта пользователя, которую нужно проверить
     */
    void validate(String email);
}
