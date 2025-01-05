package com.maxima.broker_service.service;

import com.maxima.broker_service.dto.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class MessageBrokerService {

    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>> queues = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, List<String>> subscribers = new ConcurrentHashMap<>();

    // Добавить сообщение в очередь
    public void sendMessage(String queue, Message message) {
        queues.computeIfAbsent(queue, t -> new ConcurrentLinkedQueue<>()).add(message);
    }
    // Получить сообщение из очереди
    public Message consumeMessage(String queueName) {
        ConcurrentLinkedQueue<Message> queue = queues.get(queueName);
        if (queue == null || queue.isEmpty()) {
            return null;
        }

        //Вытаскивает из очереди сообщение и его нам отдает
        return queue.poll();
    }
    // Добавить подписчика на тему
    public void subscribe(String queueName, String subscribeId) {
        subscribers.computeIfAbsent(queueName, t -> new ArrayList<>()).add(subscribeId);
    }

    // Получить подписчиков из темы
    public List<String> getSubscribers(String queueName) {
        return subscribers.get(queueName);
    }
}
