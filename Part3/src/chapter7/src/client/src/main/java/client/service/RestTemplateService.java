package client.service;

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
}
