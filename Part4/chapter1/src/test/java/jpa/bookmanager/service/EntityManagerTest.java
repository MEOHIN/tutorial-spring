package jpa.bookmanager.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("select u from User u").getResultList());  //  User 라는 entity 에서 entity 를 u 라고 표시할 때 User 정보를 가져온다. 이것을 list 로 가져온다. = userRepository.findAll()
    }
}
