package com.maxima.rest_security.repository;

import com.maxima.rest_security.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getByEmail(String email);

    Optional<Account> findByToken(String token);
}
