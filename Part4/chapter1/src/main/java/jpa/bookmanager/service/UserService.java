package jpa.bookmanager.service;

import jpa.bookmanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void put() {
//        User 라는 entity 는 비영속, 즉 new 상태에 존재
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");

//        영속화
        entityManager.persist(user);
//        detached
        entityManager.detach(user);


        user.setName("newUserAfterPersist");    // managed 의 경우 save 을 실행하지 않더라도 Transaction 이 종료되는 시점에 update 쿼리가 실행되서 데이터가 반영된다.
    }
}
