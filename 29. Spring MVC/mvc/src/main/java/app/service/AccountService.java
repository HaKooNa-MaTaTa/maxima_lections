package app.service;

import app.dto.AccountDto;

import java.util.List;

public interface AccountService {

    void signUp(AccountDto dto);

    List<AccountDto> getAll();
}
