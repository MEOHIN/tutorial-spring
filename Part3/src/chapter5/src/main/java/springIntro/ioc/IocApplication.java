package springIntro.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		SpringApplication.run(IocApplication.class, args);

		ApplicationContext context = ApplicationContextProvider.getContext();

//		DI 해줄거지만 IoC, 객체관리,는 new 관리
//		Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//		UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

//		Encoder encoder = new Encoder(base64Encoder);
//		Encoder encoder = context.getBean(Encoder.class);
		Encoder encoder = context.getBean("urlEncode", Encoder.class);

		String url = "www.naver.com/books/it?page=206&name=spring-boot";

		String result = encoder.encode(url);
		System.out.println(result);

//		encoder.setiEncoder(urlEncoder);
//		result = encoder.encode(url);
//		System.out.println(result);
	}

}


@Configuration
		//  하나의 클래스에서 여러개의 bean 을 등록한다는 의미
class AppConfig {

	@Bean("base64Encode")
	public Encoder encoder(Base64Encoder base64Encoder) {
		return new Encoder(base64Encoder);
	}

	@Bean("urlEncode")
	public Encoder encoder(UrlEncoder urlEncoder) {
		return new Encoder(urlEncoder);
	}
}