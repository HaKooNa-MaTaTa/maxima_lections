package com.maxima.producer_service.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class ProducerService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "10 * * * * *")
    public void sendMessage() {
        String url = "http://localhost:8082/broker/queue/test1";
        String message = UUID.randomUUID() + ": тестовое сообщение";
        restTemplate.postForEntity(url, message, String.class);
    }
}
