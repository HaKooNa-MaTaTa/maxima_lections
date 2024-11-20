package com.maxima.request_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Информация по клиенту
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfoDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String seriesPassport;
    private String numberPassport;
    private Integer currentMonthlyPayment;
    private Integer currentMonthlySalary;
    private Integer currentZarplata;
    //TODO: это - "хорошая кредитная история"
    private Boolean goodCreditHistory;
}
