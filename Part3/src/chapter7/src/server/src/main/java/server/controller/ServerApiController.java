package server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import server.dto.ServerUser;

@Slf4j
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

    @PostMapping("/user/{userId}/name/{userName}")
    public ServerUser post(@RequestBody ServerUser serverUser, @PathVariable int userId, @PathVariable String userName) {
        log.info("userId: {}, userName: {}", userId, userName);
        log.info("client : {}", serverUser);

        return serverUser;
    }
}
