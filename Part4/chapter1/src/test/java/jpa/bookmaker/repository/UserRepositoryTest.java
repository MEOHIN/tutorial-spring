package jpa.bookmaker.repository;

import jpa.bookmaker.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest     // Spring Context 를 로딩해서 테스트에 활용하겠다
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {   // create read update delete
        userRepository.save(new User());    // NoArgsConstructor 를 이용해서 생성하고 그것을 table 에 저장

        userRepository.findAll().forEach(System.out::println);
//        System.out.println(">>>>" + userRepository.findAll());      // user 테이블에 있는 모든 데이터를 list 형식으로 가져오겠다
    }
}