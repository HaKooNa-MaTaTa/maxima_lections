package project.service;

import project.dto.SignUpForm;
import project.model.Account;

public interface AccountService {

    void save(SignUpForm form);

    Account findById(String id);

    void deleteById(String id);
}
