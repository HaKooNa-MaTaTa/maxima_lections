package com.maxima.rab_and_kafka.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Collections;
import java.util.Properties;

public class KafkaReceiver {

    private static final String KAFKA_HOST = "localhost:9092";
    private static final String TOPIC_NAME = "terst_topic";
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KAFKA_HOST);
        properties.put("group.id", "null");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        //Создаем паблишера, который будет кидать сообщения в топик
        try (Consumer<String, String> consumer = new KafkaConsumer<>(properties)) {

            consumer.subscribe(Collections.singletonList(TOPIC_NAME));
            consumer.seek(new TopicPartition(TOPIC_NAME, 1), 0);
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1_000);

                for (ConsumerRecord<String, String> rec : records) {
                    System.out.printf("Received: key = %s, value = %s, offset = %s \n", rec.key(), rec.value(), rec.offset());
                }
            }
        }
    }
}
