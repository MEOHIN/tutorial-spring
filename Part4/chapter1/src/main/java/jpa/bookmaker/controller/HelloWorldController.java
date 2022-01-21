package jpa.bookmaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // RestAPI 요청을 받을 수 있다.
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }
}
