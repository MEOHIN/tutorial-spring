package jpa.bookmaker.repository;

import jpa.bookmaker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data JPA 라이브러리가 지원해주는 영역: 자바 인터페이스 선언 + jpa 인터페이스를 상속받음
// JpaRepository<entity 타입, PK 타입>
public interface UserRepository extends JpaRepository<User, Long> {
}
