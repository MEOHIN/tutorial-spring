package validation.async.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import validation.async.service.AsyncService;

import java.util.concurrent.CompletableFuture;

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
//    CompletableFuture : 다른 쓰레드에서 실행시키고 결과를 받음
    private CompletableFuture hello () {
        log.info("Completable future init");
        return asyncService.run();
    }
}
