package com.maxima.rab_and_kafka.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;
import java.util.UUID;

public class KafkaSender {

    private static final String KAFKA_HOST = "localhost:9092";
    private static final String TOPIC_NAME = "terst_topic";
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KAFKA_HOST);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //Создаем паблишера, который будет кидать сообщения в топик
        try (Producer<String, String> producer = new KafkaProducer<>(properties)) {

            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                String key = "key" + (random.nextInt(3) + 1);
                String message = "Message: " + UUID.randomUUID();

                ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, key, message);
                producer.send(record);

                System.out.println("Sent: " + message + " with Key: " + key);
            }
        }
    }
}
