package server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import server.dto.Req;
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
    public Req<ServerUser> post(
                                @RequestBody Req<ServerUser> serverUser,
                                @PathVariable int userId,
                                @PathVariable String userName,
                                @RequestHeader("x-authorization") String authorization,
                                @RequestHeader("custom-header") String customHeader) {
        log.info("userId : {}, userName : {}", userId, userName);
        log.info("authorization: {}, custom : {}", authorization, customHeader);
        log.info("client : {}", serverUser);

        Req<ServerUser> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );

        response.setResBody(serverUser.getResBody());

        return response;
    }
}
