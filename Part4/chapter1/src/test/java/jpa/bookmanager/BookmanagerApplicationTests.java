package jpa.bookmanager;
class BookmanagerApplicationTests {}

// 컨테이너 로딩하는 테스트, 전체 테스트 하면 스프링 컨테이너가 한번 더 동작하면서 data.sql을 한번 더 실행하게 되고,
// 테스트 실행시에 실행된 data.sql과 primary key 제약 조건에 마주치면서 예외가 발생.

/*
package jpa.bookmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookmanagerApplicationTests {

    @Test
    void contextLoads() {
    }

}
*/