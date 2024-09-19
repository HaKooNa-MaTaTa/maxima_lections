package app.repository;

import app.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
//@Component == @Service == @Repository
/**
 * Реализация интерфейса {@link AccountRepository} основанная на InMemory
 */
@Repository //Данная аннотация указывает на то, что данный класс работает с неким хранилищем данных
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
