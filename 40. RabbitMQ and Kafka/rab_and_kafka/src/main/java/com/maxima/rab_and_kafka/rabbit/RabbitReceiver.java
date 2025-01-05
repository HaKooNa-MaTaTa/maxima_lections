package com.maxima.rab_and_kafka.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

public class RabbitReceiver {
    private final static String QUEUE_NAME = "test_queue_1";
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            //Объявляем очередь, в которую будем писать
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            //Что делать, если пришло сообщение в очередь
            DeliverCallback deliverCallback = ((consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println("Received: " + message);
            });
            //Начинаем слушать очередь
            while (true) {
                channel.basicConsume(QUEUE_NAME,true, deliverCallback, consumerTag -> {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
