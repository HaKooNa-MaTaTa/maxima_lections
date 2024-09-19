package app.service;

import app.model.Account;

/**
 * Интерфейс сервиса, отвечающего за работу с сущностью {@link Account}
 */
public interface AccountService {

    /**
     * Метод сохранения аккаунта пользователя
     *
     * @param account аккаунт пользователя, который нужно сохранить
     */
    void save(Account account);
}
