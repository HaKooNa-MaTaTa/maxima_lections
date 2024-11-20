package com.maxima.request_service.model;

//Информация о клиенте

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String patronymic;

    @Column(name = "series_passport")
    private String seriesPassport;

    @Column(name = "number_passport")
    private String numberPassport;

    @Column(name = "current_monthly_payment")
    private Integer currentMonthlyPayment;

    @Column(name = "current_monthly_salary")
    private Integer currentMonthlySalary;

    @Column(name = "current_zarplata")
    private Integer currentZarplata;
    //TODO: это - "хорошая кредитная история"

    @Column(name = "good_credit_history")
    private Boolean goodCreditHistory;
}
