package com.maxima.central_bank.service;

import com.maxima.central_bank.dto.ClientInfoDto;
import com.maxima.central_bank.dto.RequestOnCreditDto;
import org.springframework.http.ResponseEntity;

public interface CreditService {

    RequestOnCreditDto createRequest(ClientInfoDto dto);
}
