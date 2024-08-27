package app.repository;

import app.model.Account;

import java.util.HashSet;
import java.util.Set;

/**
 * Реализация интерфейса {@link AccountRepository} основанная на InMemory
 */
public class AccountRepositoryInMemoryImpl implements AccountRepository {

    private final Set<Account> accounts = new HashSet<>();
    @Override
    public void save(Account account) {
        System.out.println("Сохраняем аккаунт");
        System.out.println("Имя пользователя - " + account.getFirstName());
        System.out.println("Фамилия пользователя - " + account.getLastName());
        System.out.println("Мыло пользователя - " + account.getEmail());
        boolean resultSave = accounts.add(account);

        System.out.println(resultSave ? "Аккаунт сохранен" : "Не получилось сохранить аккаунт");
    }
}
