package jpa.bookmanager.service;

import jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    /** entity life cycle 상태를 확인하는 테스트  */
    @Test
    void test() {
        userService.put();

        System.out.println(">>>> " + userRepository.findByEmail("newUser@fastcampus.com"));
    }
}