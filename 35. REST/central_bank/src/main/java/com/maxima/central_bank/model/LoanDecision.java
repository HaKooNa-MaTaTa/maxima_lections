package com.maxima.central_bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Решение банка по заявке
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDecision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    private RequestOnCredit requestOnCredit;

    @Column(name = "final_decision")
    private Boolean finalDecision;

    @Column(name = "amount_of_credit")
    private Integer amountOfCredit;

    @Column(name = "monthly_payment")
    private Integer monthlyPayment;
}
