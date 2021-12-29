package response.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

//    TEXT 로 response 를 내려주는 방법
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

//    JSON 으로 response 를 내려주는 방법
/*    실제 동작 방식
        request 가 오면, object mapper 를 통해 object 로 바 -> 생성한 json 메소드 실행 -> response 로 object 를 던지면 -> object mapper 를 통해 json 으로 바뀌어서 response 가 내려감
 */
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

//    응답에 대한 커스터마이징: ResponseEntity
//    예: 201 에 대해 response 를 내려주는 방법
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
