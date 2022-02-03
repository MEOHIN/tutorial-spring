package jpa.bookmaker.repository;

import jpa.bookmaker.domain.User;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//Spring Data JPA 라이브러리가 지원해주는 영역: 자바 인터페이스 선언 + jpa 인터페이스를 상속받음
// JpaRepository<entity 타입, PK 타입>
public interface UserRepository extends JpaRepository<User, Long> {
    /** query method : 본인이 사용하기에 가독성이 높은 걸로 사용
     * 필요에 따라 가독성을 위해 제공되는 접두어 사용가능 */
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

}
