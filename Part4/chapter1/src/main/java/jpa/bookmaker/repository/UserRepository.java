package jpa.bookmaker.repository;

import jpa.bookmaker.domain.User;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//Spring Data JPA 라이브러리가 지원해주는 영역: 자바 인터페이스 선언 + jpa 인터페이스를 상속받음
// JpaRepository<entity 타입, PK 타입>
public interface UserRepository extends JpaRepository<User, Long> {
    /** query method : 본인이 사용하기에 가독성이 높은 걸로 사용
     * query method naming 규칙을 이용해서 필요에 따라 가독성을 위해 제공되는 접두어 사용가능 */
    Set<User> findByName(String name);   // 리턴받을 type 은 User 라는 entity 이고 User 단위 객체로 리턴하고, 이름 통해서 user 를 가져오는 method

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    User findSomethingByEmail(String email);

    List<User> findTop2ByEmail(String email);

    List<User> findFirst2ByEmail(String email);

    User findLast1ByEmail(String email);

    List<User> findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id1, Long id2);

    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<User> findByIdIsNotNull();

//    List<User> findByAddressIsNotEmpty();   // name is not null and name != '' ?? 과는 다른 것임을 명심

    List<User> findByNameIn(List<String> names);

    /*
    startWith, endWith, contains 는 문자열에 관한 쿼리로 동작하고 like 검색을 제공: startWith, endWith, contains 는 findByNameLik 로 매핑한 것과 동일
     */

    List<User> findByNameStartingWith(String names);

    List<User> findByNameEndingWith(String names);

    List<User> findByNameContains(String names);

    List<User> findByNameLike(String names);

//    is : 코드 가독성을 높이는 용도로 사용
    Set<User> findUserByNameIs(String names);
    Set<User> findUserByName(String names);
    Set<User> findUserByNameEquals(String names);

    List<User> findTop1ByName(String name);

    List<User> findLast1ByName(String name);

    List<User> findTopByNameOrderByIdDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<User> findFirstByName(String name, Sort sort);
}
