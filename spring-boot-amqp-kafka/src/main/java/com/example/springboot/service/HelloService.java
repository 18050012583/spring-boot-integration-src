package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final KafkaTemplate kafkaTemplate;

    public HelloService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * 监听topic
     * @param msg
     */
    @KafkaListener(topics = "testTopic")
    public void receiveMsg(String msg){
        System.out.println(msg);
    }

    /**
     * 发送消息
     * @param msg
     */
    public void sendMsg(String msg) {
        kafkaTemplate.send("testTopic",msg);
    }
}