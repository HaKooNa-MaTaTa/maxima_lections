package mvc.repository;

import mvc.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository {

    void save(Account account);

    List<Account> getAllAccounts();
    Account getByEmail(String email);
}
