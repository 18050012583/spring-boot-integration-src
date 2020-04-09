package com.example.springboot;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SpringBootDataMongoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSave() {
        User user = new User();
        user.setId("1");
        user.setUsername("chenjf");
        userRepository.save(user);
    }

    @Test
    void testGet() {
        Optional<User> byId = userRepository.findById("1");
        if (byId.isPresent()) {
            User user = byId.get();
            System.out.println(user);
        } else {
            System.out.println("not found");
        }
    }

}
