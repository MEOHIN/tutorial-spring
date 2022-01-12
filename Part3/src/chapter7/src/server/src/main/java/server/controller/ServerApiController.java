package server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.dto.ServerUser;

@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public ServerUser hello() {

        ServerUser user = new ServerUser();
        user.setName("steve");
        user.setAge(10);

        return user;
    }
}
