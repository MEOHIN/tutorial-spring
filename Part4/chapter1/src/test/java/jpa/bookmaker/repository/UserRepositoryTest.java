package jpa.bookmaker.repository;

import jpa.bookmaker.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest     // Spring Context 를 로딩해서 테스트에 활용하겠다
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {   // create read update delete
//        userRepository.save(new User());    // NoArgsConstructor 를 이용해서 생성하고 그것을 table 에 저장
//
//        userRepository.findAll().forEach(System.out::println);
//        System.out.println(">>>>" + userRepository.findAll());      // user 테이블에 있는 모든 데이터를 list 형식으로 가져오겠다

//        보통 List 타입은 변수명으로 복수형을 사용한다.
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));    // 알파벳 역순 출력

        users.forEach(System.out::println);
    }
}