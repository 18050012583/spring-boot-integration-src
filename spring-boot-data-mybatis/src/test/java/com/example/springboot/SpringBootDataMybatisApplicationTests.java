package com.example.springboot;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootDataMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testCreate() {
        User user = new User();
        user.setId(2);
        user.setUsername("chenbao");
        userMapper.addUser(user);
    }

    @Test
    void testFindAll() {
        List<User> all = userMapper.findAll();
        all.forEach(System.out::println);
    }

}
