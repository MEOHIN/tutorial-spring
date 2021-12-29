package objectMapper;

/**		object mapper
 * 		text 형태의 json 을 object 로 바꿔주거나 object 를 text 형태의 json 올 바꿔줌
 * 		controller 에서 request 로 json(text 형태) 가 들어오면, 자동으로 object 로 바꿔주거나
 * 		response 를 object 로 return 하면, 자동으로 json(text 형태) 바꿔줌
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("hello");

//		object mappter 생성
		var objectMapper = new ObjectMapper();

//		object -> json (text)
//		이 때 object mapper 가 get method 를 활용한다. -> 내가 작성한 클래스가 object mappter 에서 활용될 경우, 해당 클래스의 메소드 이름에 get을 사용하면 안된다.
		var user = new User("steve", 10, "010-1111-2222");

		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);

//		json (text) -> object
//		object mapper 는 default 생성자를 필요로 한다.
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
	}

}
