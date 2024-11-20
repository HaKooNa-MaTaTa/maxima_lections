package com.maxima.request_service.service;

import com.maxima.request_service.dto.ClientInfoDto;
import com.maxima.request_service.dto.RequestOnCreditDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestOnCreditServiceImpl implements RequestOnCreditService {


    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<RequestOnCreditDto> createRequest(ClientInfoDto info) {
        return restTemplate.postForEntity("http://localhost:8081/credit", info, RequestOnCreditDto.class);
    }
}
