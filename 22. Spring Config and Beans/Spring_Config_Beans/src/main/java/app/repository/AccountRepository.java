package app.repository;

import app.model.Account;

/**
 * Репозиторий, отвечающий за работу с сущностью Account
 */
public interface AccountRepository {

    /**
     * Метод сохранения аккаунта пользователя
     *
     * @param account аккаунт пользователя, который нужно сохранить
     */
    void save(Account account);
}
