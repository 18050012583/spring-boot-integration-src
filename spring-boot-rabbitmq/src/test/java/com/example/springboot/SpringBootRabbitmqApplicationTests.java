package com.example.springboot;

import com.example.springboot.entity.User;
import com.example.springboot.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRabbitmqApplicationTests {

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Autowired
    private HelloService helloService;

    @Test
    void createQueue() {
        Queue queue = new Queue("user-queue");
        rabbitAdmin.declareQueue(queue);
    }

    @Test
    void createExchange() {
        Exchange exchange = new TopicExchange("user-exchange");
        rabbitAdmin.declareExchange(exchange);
    }

    @Test
    void createBinding() {
        Binding binding = new Binding("user-queue",Binding.DestinationType.QUEUE,"user-exchange",
                "user-key",null);
        rabbitAdmin.declareBinding(binding);
    }

    @Test
    void testSend() {
        User user = new User();
        user.setUsername("chenjf");
        user.setPassword("password");
        helloService.send(user);
    }
}
