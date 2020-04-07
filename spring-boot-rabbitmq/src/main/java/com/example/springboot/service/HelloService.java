package com.example.springboot.service;

import com.example.springboot.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final RabbitTemplate rabbitTemplate;

    public HelloService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "user-queue")
    public void receive(User user){
        System.out.println("收到消息：" + user);
    }

    public void send(User user){
        rabbitTemplate.convertAndSend("user-exchange","user-key",user);
    }
}
