package jpa.bookmanager.service;

import jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    /**
     * entity manager 를 Autowired 로 연결해서 사용하는 테스트
     */
    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("select u from User u").getResultList());  //  User 라는 entity 에서 entity 를 u 라고 표시할 때 User 정보를 가져온다. 이것을 list 로 가져온다. = userRepository.findAll()
    }

    /**
     * find 를 사용해서 cache 역할을 살펴보는 테스트
     * select query 는 한 번 실행, System out 은 세 번 실생됨.
     *  즉, 조회시에 진짜 DB 에 쿼리를 조회하지 않고, 영속성 컨텍스트 내에 존재하는 entity cache 에서 직접처리한다.
     *  따로 cache 설정을 하지 않았지만, 영속성 컨텍스트 내에서 자동으로 entity 에 대해서 cache 처리하는 것을 일반적으로 JPA 의 1차 cache 라고 한다.
     */
    @Test
    void cacheFindTest() {
        System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findById(1L).get());
    }
}
