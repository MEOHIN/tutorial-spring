package springIntro.ioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base64")  //spring 에서 컴포넌트로 관리해달라는 뜻
public class Base64Encoder implements IEncoder {

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
