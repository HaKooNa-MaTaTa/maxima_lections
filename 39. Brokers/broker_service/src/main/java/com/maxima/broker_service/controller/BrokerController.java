package com.maxima.broker_service.controller;

import com.maxima.broker_service.dto.Message;
import com.maxima.broker_service.service.MessageBrokerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/broker")
public class BrokerController {

    private final MessageBrokerService service;

    @Autowired
    public BrokerController(MessageBrokerService service) {
        this.service = service;
    }

    //Отправить сообщение
    @PostMapping("/queue/{queue}")
    public String sendMessage(@PathVariable String queue, @RequestBody String body) {
        Message message = new Message(UUID.randomUUID(), body);
        service.sendMessage(queue, message);
        return "Message sent to queue: " + queue;
    }

    //Получить сообщение
    @GetMapping("/queue/{queue}")
    public Message consumeMessage(@PathVariable String queue) {
        Message message = service.consumeMessage(queue);
        if (message == null) {
            throw new RuntimeException("No messages in queue: " + queue);
        }

        return message;
    }

    //Подписаться
//    @PostMapping("/topic/{topic}/subscribe")
//    public String subscribe(@PathVariable String )
}
