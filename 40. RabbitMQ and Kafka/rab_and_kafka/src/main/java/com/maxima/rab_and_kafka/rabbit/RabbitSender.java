package com.maxima.rab_and_kafka.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class RabbitSender {

    private final static String QUEUE_NAME = "test_queue_1";
    private final static String EXCHANGE_NAME = "test_exchange_1";
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            //Объявляем очередь, в которую будем писать
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            //Отправим несколько сообщений
            while (true) {
                Thread.sleep(1_000);
                String message = String.format("This message ID - %s", UUID.randomUUID());
                channel.basicPublish(EXCHANGE_NAME, "test_routing_key_1", null, message.getBytes(StandardCharsets.UTF_8));
                System.out.println("Sent:  " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
