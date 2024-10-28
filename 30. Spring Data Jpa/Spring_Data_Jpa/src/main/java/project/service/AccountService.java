package project.service;

import project.dto.SignUpForm;
import project.model.Account;

import java.util.List;

public interface AccountService {

    void save(SignUpForm form);

    Account findById(Long id);

    void deleteById(Long id);

    List<Account> findByLastName(String lastName);

    List<Account> findByEmail(String email);
}
