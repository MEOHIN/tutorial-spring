package client.service;

import client.dto.UserRequest;
import client.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {


//    http://localhost/api/server/hello 호출하고

//    response 받기

    public UserResponse hello() {
//        어떻게 통신하냐?: client 가 되어야 하기 때문에 RestTemplate 사용
//        URL 만들기
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "jack")
                .queryParam("age", 80)
                .encode()
                .build()
                .toUri();

//        주소가 잘 만들어졌는 지 확인
        System.out.println(uri.toString());

//        Rest Template 만들기
        RestTemplate restTemplate = new RestTemplate();
//        getForObject 의 get 은 가져오겠다는 뜻이 아니라 Http 메소두의 GET
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);   // getForObject 가 실행되는 순간 client 에서 http(서버)로 붙는 순간

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    public UserResponse post() {
//        http://localhost:9090/api/server/user/{userId}/name/{userName}

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100", "steve")
                .toUri();

        System.out.println(uri);

//        post 이므로 http body 가 필요 -> 하지만 나는 object 만 보낸다 -> 그러면 object mapper 가 알아서 -> json 으로 바꾸고 -> rest template 에서 -> http body 에 json 으로 넣어줌
        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();
    }
}
