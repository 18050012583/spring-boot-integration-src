package com.example.springboot;

import com.example.springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringBootDataRedisApplicationTests {

    @Autowired
    private RedisTemplate<Object, User> redisTemplate;

    @Test
    void testSave() {
        User user = new User();
        user.setUsername("chenjf");
        user.setPassword("password");
        redisTemplate.opsForValue().set("user",user);
    }

    @Test
    void testGet() {
        User user = redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }
}
