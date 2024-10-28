package project.repository.old_version;

import project.dto.SignUpForm;
import project.model.Account;

public interface AccountRepository {

    void save(SignUpForm form);

    Account findById(Long id);

    void deleteById(Long id);
}
