package validation.exception.controller;

import org.springframework.web.bind.annotation.*;
import validation.exception.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("")
    public User get(@RequestParam String name, @RequestParam(required = false) Integer age) {

        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10+age;

        return user;
    }

    @PostMapping("")
    public User post(@RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
