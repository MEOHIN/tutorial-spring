package server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import server.dto.ServerUser;

@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public ServerUser hello(@RequestParam String name, @RequestParam int age) {

        ServerUser user = new ServerUser();
        user.setName(name);
        user.setAge(age);

        return user;
    }
}
