package jpa.bookmaker.repository;

import jpa.bookmaker.domain.Gender;
import jpa.bookmaker.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

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

//        System.out.println(userRepository.findByName("denis"));
//
//        System.out.println("findByEmail: " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail: " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail: " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail: " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail: " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail: " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail: " + userRepository.findUserByEmail("martin@fastcampus.com"));
//
//        System.out.println("findSomethingByEmail: " + userRepository.findSomethingByEmail("martin@fastcampus.com"));
//
//        System.out.println("findTop2ByEmail: " + userRepository.findTop2ByEmail("martin@fastcampus.com"));
//        System.out.println("findFirst2ByEmail: " + userRepository.findFirst2ByEmail("martin@fastcampus.com"));
//        System.out.println("findLast1ByEmail: " + userRepository.findLast1ByEmail("martin@fastcampus.com"));

        System.out.println("findByEmailAndName: " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
        System.out.println("findByEmailORName: " + userRepository.findByEmailOrName("martin@fastcampus.com", "martin"));

        System.out.println("findByCreatedAtAfter: " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter: " + userRepository.findByIdAfter(4L));

        System.out.println("findByCreatedAtGreaterThan: " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual: " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtBetween: " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween: " + userRepository.findByIdBetween(1L, 3L));
/*        findByIdBetween 쿼리와 findByCreatedAtGreaterThanEqualAndIdLessThanEqual 쿼리는 동일한 쿼리 -> 쿼리상의 논리적인 오류가 있다것을 꼭 알고가자
            equal 유뮤를 꼭 조심하자.
            Between 에는 equal 이 포함되는 것을 명심
 */
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual: " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

        System.out.println("findByIdIsNotNull: " +userRepository.findByIdIsNotNull());
        /*
        notEmpty 는 문자열이 아닌, 컬렉션 상의 notEmpty 의미
         */
//        System.out.println("findByAddressIsNotEmpty: " +userRepository.findByAddressIsNotEmpty());

        System.out.println("findByNameIn: " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));

        System.out.println("findByNameStartingWith: " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith: " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains: " + userRepository.findByNameContains("art"));

        System.out.println("findByNameLike: " + userRepository.findByNameLike("%art%"));
    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName: " + userRepository.findTop1ByName("martin"));
        System.out.println("findLast1ByName: " + userRepository.findLast1ByName("martin")); // Last 가 무시되고 findByName 과 동일하게 동작
//        findLast1ByName 이 동작하라게 하려면 findTop1ByNameOrderByIdDesc 을 이용해 역순으로 가져올 있음
        System.out.println("findTopByNameOrderByIdDesc: " + userRepository.findTopByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc: " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
        System.out.println("findFirstByNameWithSortPrams: " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findByNameWithPaging: " + userRepository.findByName("martin", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("martin");
        user.setEmail("martin@fastcampus.com");

        userRepository.save(user);

        User user1 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user1.setName("marrrrrtin");

        userRepository.save(user1);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest(){
        User user = new User();
        user.setName("martin");
        user.setEmail("martin@fastcampus.com");

        userRepository.save(user);

        User user1 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user1.setName("marrrrrtin");

        userRepository.save(user1);

        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest() {
        User user = new User(); // user 새로 생성
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin2@fastcampus.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findByEmail("martin@fastcampus.com");

        System.out.println("as-is: " +user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be: " + userRepository.findAll().get(0));
    }
}