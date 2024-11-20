package com.maxima.central_bank.controller;


import com.maxima.central_bank.dto.ClientInfoDto;
import com.maxima.central_bank.dto.RequestOnCreditDto;
import com.maxima.central_bank.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    public ResponseEntity<RequestOnCreditDto> createRequest(@RequestBody ClientInfoDto clientInfoDto) {
        return ResponseEntity.ok(creditService.createRequest(clientInfoDto));
    }
}
