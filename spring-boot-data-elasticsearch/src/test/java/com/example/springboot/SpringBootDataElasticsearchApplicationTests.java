package com.example.springboot;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDataElasticsearchApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSave() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setUsername("chenjf");
        userRepository.save(user);
    }

    @Test
    void testGet() {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("username", "chenjf");
        Iterable<User> search = userRepository.search(matchQueryBuilder);
        search.forEach(System.out::println);
    }

}
