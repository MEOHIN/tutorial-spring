package jpa.bookmaker.repository;

import jpa.bookmaker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Spring Data JPA 라이브러리가 지원해주는 영역: 자바 인터페이스 선언 + jpa 인터페이스를 상속받음
// JpaRepository<entity 타입, PK 타입>
public interface UserRepository extends JpaRepository<User, Long> {
    /** query method    */
    User findByName(String name);   // 리턴받을 type 은 User 라는 entity 이고 User 단위 객체로 리턴하고, 이름 통해서 user 를 가져오는 method
}
