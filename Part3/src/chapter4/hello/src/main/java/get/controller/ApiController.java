package get.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 class 는 REST API 처리하는 Controller annotation
@RequestMapping("/api") // RequestMapping URL 를 지정해주는 annotation; 주소를 할당
public class ApiController {

    @GetMapping("/get")   // http://localhost:8080/api/hello; get 방식으로 api 열어주기 위해서 설정
    public String hello() {
        return "hello spring boot";
    }
}
