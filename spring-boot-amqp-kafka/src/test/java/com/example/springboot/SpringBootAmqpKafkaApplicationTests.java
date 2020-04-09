package com.example.springboot;

import com.example.springboot.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootAmqpKafkaApplicationTests {

    @Autowired
    private HelloService helloService;

    @Test
    void testSend() {
        helloService.sendMsg("hello kafka");
    }

}
