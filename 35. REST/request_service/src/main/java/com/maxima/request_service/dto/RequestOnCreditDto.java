package com.maxima.request_service.dto;

import com.maxima.request_service.model.ClientInfo;
import com.maxima.request_service.model.LoanDecision;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestOnCreditDto {

    private Long id;
    private ClientInfo clientInfo;
    private LoanDecision loanDecision;
}
