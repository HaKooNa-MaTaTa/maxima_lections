package com.maxima.broker_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * ДТО сообщения
 */
public class Message {

    private UUID id;
    private String message;

    public Message(UUID id, String message) {
        this.id = id;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
