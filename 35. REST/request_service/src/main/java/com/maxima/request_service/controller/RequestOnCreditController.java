package com.maxima.request_service.controller;

import com.maxima.request_service.dto.ClientInfoDto;
import com.maxima.request_service.dto.RequestOnCreditDto;
import com.maxima.request_service.service.RequestOnCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер, для подачи заявки на кредит
 */
@RestController
//в качестве конечного ресурса никогда не надо использовать глаголы
@RequestMapping("/request-on-credit")
public class RequestOnCreditController {

    private final RequestOnCreditService requestOnCreditService;

    @Autowired
    public RequestOnCreditController(RequestOnCreditService requestOnCreditService) {
        this.requestOnCreditService = requestOnCreditService;
    }

    //Обертка для ответов сервера
    /**
     * Метод, принимающий {@link ClientInfoDto} информацию о клиенте и формирует запрос в ЦБ РФ
     *
     * @param user информация о клиенте
     * @return ответ ЦБ на заявку о кредите
     */
    @PostMapping
    public ResponseEntity<RequestOnCreditDto> createRequest(@RequestBody ClientInfoDto user) {
        return requestOnCreditService.createRequest(user);
    }
}
