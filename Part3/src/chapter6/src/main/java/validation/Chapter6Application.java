package validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync	// spring 을 사용하면서 async(비동기)는 어떻게 동작하는 가
public class Chapter6Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter6Application.class, args);
	}

}
