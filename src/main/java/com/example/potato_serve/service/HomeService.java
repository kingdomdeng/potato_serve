package com.example.potato_serve.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class HomeService {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMsg() {
        log.info("### producer sendMsg");
        kafkaTemplate.sendDefault("test msg");
    }

    @KafkaListener(topics = "kafka_topic", groupId = "group_test1")
    public void consumer(
            @Payload String message,
            @Header("kafka_receivedTimestamp") String kafka_receivedTimestamp,
            @Header("kafka_offset") String kafka_offset
    ) {
        log.info("### customer kafka_offset: {}, kafka_receivedTimestamp: {}", kafka_offset, kafka_receivedTimestamp);
        log.info("### customer kafka_topic message: {}", message);
    }
}
