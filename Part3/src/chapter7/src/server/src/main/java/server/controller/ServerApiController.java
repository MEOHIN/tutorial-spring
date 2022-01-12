package server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import server.dto.Req;
import server.dto.ServerUser;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {
//        https://openapi.naver.com
//        /v1/search/local.json
//        ?query=%EC%A3%BC%EC%8B%9D
//        &display=10
//        &start=1
//        &sort=random
    @GetMapping("/naver")
    public String naver(){

        String query = "갈비집";
        String encode = Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8));

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", "갈비집")
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        log.info("url : {}", uri);

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "ZlEvjSz5ieDgX2yt3wtF")
                .header("X-Naver-Client-Secret", "l6JxGtGIgn")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        return result.getBody();
    }

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
