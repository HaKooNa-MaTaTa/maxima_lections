package com.maxima.central_bank.repository;

import com.maxima.central_bank.model.LoanDecision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanDecisionRepository extends JpaRepository<LoanDecision, Long> {

}
