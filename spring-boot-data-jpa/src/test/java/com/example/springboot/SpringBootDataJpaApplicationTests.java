package com.example.springboot;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SpringBootDataJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        User user = new User();
        user.setUsername("chenjf");
        userRepository.save(user);
    }

    @Test
    public void testFind() {
        Optional<User> byId = userRepository.findById(1);
        if (byId.isPresent()) {
            System.out.println(byId.get());
        } else {
            System.out.println("not found");
        }
    }
}
