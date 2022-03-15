package jpa.bookmanager.service;

import jpa.bookmanager.domain.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Transactional
    public void put() {
//        User 라는 entity 는 비영속, 즉 new 상태에 존재
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");
    }
}
