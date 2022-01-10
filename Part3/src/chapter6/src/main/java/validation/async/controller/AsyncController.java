package validation.async.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import validation.async.service.AsyncService;

@Slf4j
@RestController
@RequestMapping("/api")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/hello")
    private String hello () {
//        async 어노테이션덕분에 기다리지 않고 바로 "hello" 를 return 한다.
        asyncService.hello();

        log.info("method end");
        return "hello";
    }
}
