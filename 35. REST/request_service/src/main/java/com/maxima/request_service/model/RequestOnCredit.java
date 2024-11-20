package com.maxima.request_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Заявка на кредит
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestOnCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ClientInfo clientInfo;

    @OneToOne
    private LoanDecision loanDecision;
}
