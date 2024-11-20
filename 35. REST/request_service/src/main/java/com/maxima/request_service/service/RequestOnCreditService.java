package com.maxima.request_service.service;

import com.maxima.request_service.dto.ClientInfoDto;
import com.maxima.request_service.dto.RequestOnCreditDto;
import org.springframework.http.ResponseEntity;

public interface RequestOnCreditService {

    ResponseEntity<RequestOnCreditDto> createRequest(ClientInfoDto info);

}
