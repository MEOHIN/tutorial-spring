package jpa.bookmaker.repository;

import jpa.bookmaker.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest     // Spring Context 를 로딩해서 테스트에 활용하겠다
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional  // Session 유지
    void crud() {   // create read update delete
//        userRepository.save(new User());    // NoArgsConstructor 를 이용해서 생성하고 그것을 table 에 저장 -> insert query 생성
//
//        userRepository.findAll().forEach(System.out::println);
//        System.out.println(">>>>" + userRepository.findAll());      // user 테이블에 있는 모든 데이터를 list 형식으로 가져오겠다

//        /* 보통 List 타입은 변수명으로 복수형을 사용한다. */
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

//        /* getOne 은 entity 에 대해서 lazy 한 로딩을 지원 */
//        User user = userRepository.getOne(1L);

//        User user = userRepository.findById(1L).orElse(null);

//        System.out.println(user);

//        /* Flush 는 DB 반영 시점에 영향은 주지만, log 에서는 변화를 찾아볼 수 없다.    */
//        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));

//        userRepository.findAll().forEach(System.out::println);
//        long count = userRepository.count();

//        System.out.println(count);
//        boolean exist = userRepository.existsById(1L);  // 실제로는 count query

//        System.out.println(exist);
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));  // 내가 작성한 select query 이외에 또다른 select query 가 생성됨
//        userRepository.deleteById(1L);
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));   // entity argument 를 주어도 각각의 entity 가 존재하는지 select 하고 각각 delete query 를 던짐
//        userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));   // 실제 delete query 를 한 번만 실행하고 select 도 하지 않기때문에 성능 이슈를 해결
//        userRepository.findAll().forEach(System.out::println);

//        /** paging  */
//        Page<User> users = userRepository.findAll(PageRequest.of(1, 2));
//
//        System.out.println("page: " + users);
//        System.out.println("totalElements: " + users.getTotalElements());
//        System.out.println("totalPages: " + users.getTotalPages());
//        System.out.println("numberOfElements: " + users.getNumberOfElements());
//        System.out.println("sort: " + users.getSort());
//        System.out.println("size: " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

//        /* queryByExample 이란? entity 를 example 로 만드로 matcher 를 추가해서 선언해줌으로써 필요한 query 들을 만드는 방법    */
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());
//
//        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);
//        User user = new User();
//        user.setEmail("slow");
//
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());    // 양방향
//        Example<User> example = Example.of(user, matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);

        /** SimpleJpaRepository */
        /* save 메소드가 insert query 생성   */
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        /* save 메소드가 insert update query 생성
         *  @Id 어노테이션에 할당된 값이 null 이면 insert, null 아니라면 update query 를 만들어서 처리 */
        userRepository.save(user);
    }

    @Test
    void select() {
        System.out.println(userRepository.findByName("denis"));
    }
}