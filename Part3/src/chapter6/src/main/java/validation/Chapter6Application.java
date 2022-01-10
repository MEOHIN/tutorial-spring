package validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Chapter6Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter6Application.class, args);
	}

}
