package app.repository;

import app.model.Account;

import java.util.List;

public interface AccountRepository {

    void signUp(Account dto);

    List<Account> getAll();
}
