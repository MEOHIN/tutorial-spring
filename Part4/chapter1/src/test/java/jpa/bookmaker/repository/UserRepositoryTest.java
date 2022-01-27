package jpa.bookmaker.repository;

import jpa.bookmaker.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest     // Spring Context 를 로딩해서 테스트에 활용하겠다
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional  // Session 유지
    void crud() {   // create read update delete
//        userRepository.save(new User());    // NoArgsConstructor 를 이용해서 생성하고 그것을 table 에 저장
//
//        userRepository.findAll().forEach(System.out::println);
//        System.out.println(">>>>" + userRepository.findAll());      // user 테이블에 있는 모든 데이터를 list 형식으로 가져오겠다

//        /** 보통 List 타입은 변수명으로 복수형을 사용한다. */
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));    // 알파벳 역순 출력
//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 2L, 5L));    // user 객체 long 타입의 ID 중 해당 ID만 출력
//
//        users.forEach(System.out::println);

//        User user1 = new User("jack", "jack@fastcampus.com");
//        User user2 = new User("steve", "steve@fastcampus.com");

//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//        userRepository.save(user1);

//        List<User> users = userRepository.findAll();

//        users.forEach(System.out::println);

//        /** getOne 은 entity 에 대해서 lazy 한 로딩을 지원 */
//        User user = userRepository.getOne(1L);

//        User user = userRepository.findById(1L).orElse(null);

//        System.out.println(user);

//        /** Flush 는 DB 반영 시점에 영향은 주지만, log 에서는 변화를 찾아볼 수 없다.    */
//        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));

//        userRepository.findAll().forEach(System.out::println);
//        long count = userRepository.count();

//        System.out.println(count);
//        boolean exist = userRepository.existsById(1L);  // 실제로는 count query

//        System.out.println(exist);
        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));  // 내가 작성한 select query 이외에 또다른 select query 가 생성됨
    }
}