package com.maxima.spring_boot_security.repository;

import com.maxima.spring_boot_security.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getByEmail(String email);
}
