package client.controller;

import client.dto.ClientUserResponse;
import client.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientApiController {

    @Autowired
    private RestTemplateService restTemplateService;

    public ClientApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("hello")
    public ClientUserResponse getHello () {
        return restTemplateService.hello();
    }
}
