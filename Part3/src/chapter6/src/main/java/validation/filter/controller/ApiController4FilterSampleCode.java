package validation.filter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import validation.filter.dto.User;

@Slf4j      // System Log for Java: system.out 대신 log 를 찍을 수 있음
@RestController
@RequestMapping("/api/user3")
public class ApiController4FilterSampleCode {

    @PostMapping("")
    public User user (@RequestBody User user) {
        log.info("User: {}" , user);

        return user;
    }
}
