package project.repository;

import org.springframework.stereotype.Repository;
import project.dto.SignUpForm;
import project.model.Account;

public interface AccountRepository {

    void save(SignUpForm form);

    Account findById(String id);

    void deleteById(String id);
}
