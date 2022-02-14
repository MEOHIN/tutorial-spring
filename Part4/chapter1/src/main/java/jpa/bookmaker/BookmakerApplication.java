package jpa.bookmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // 기본 listener 를 사용하기위해 auditing 하겠다는 것을 추가
public class BookmakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmakerApplication.class, args);
    }

}
