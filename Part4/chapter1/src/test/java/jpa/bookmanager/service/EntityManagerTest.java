package jpa.bookmanager.service;

import jpa.bookmanager.domain.User;
import jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * 영속성 캐시를 활용해서 id로 조회시에 얻는 이점
 * 쓰기지연에 따른 데이터 처리
 */


@SpringBootTest
// 상위 Transactional 이 존재하면 하위 Transactional 은 무시된다.
@Transactional  // 쓰기 지연이 발생 -> 트랜젝션 내에서는 DB 에 반영하는 시기를 최대한 늦춤
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
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());
    }

    /**
     * 1. cache 와 @Transactional 관계를 확인
     * 2. flush() 메소드 역할
     * 3. 영속성 cache 에 있는 query 가 실제 DB 반영되는 시점
     */

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("marrrrrrrtin");

        userRepository.save(user);  // save 구현체에 자체적으로 @Transactional 이 있다. -> save 각각이 transaction 이다.

        System.out.println("-------------------------");

        user.setEmail("marrrrrrtin@fastcampus.com");
        userRepository.save(user);

        System.out.println(">>>>> 1 : " + userRepository.findById(1L).get());  // 실제 DB 반영시기 확인

        userRepository.flush();     // DB 반영: 전체를 Transactional 로 묶을 경우 쿼리가 실행되지 않는 것을 방지하기 위해. flush 는 모여있는 것 비워낸다는 의미

        System.out.println(">>>>> 2 : " + userRepository.findById(1L).get());  // 실제 DB 반영시기 확인
    }
}
