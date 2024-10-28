package mvc.service;

import mvc.dto.AccountDto;
import mvc.model.Account;

import java.util.List;

public interface AccountService {

    void saveAccount(AccountDto accountDto);

    List<Account> getAllAccounts();
}
