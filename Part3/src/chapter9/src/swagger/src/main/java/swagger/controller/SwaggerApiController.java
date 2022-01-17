package swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import swagger.dto.UserReq;
import swagger.dto.UserRes;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class SwaggerApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping
    public int plus(
            @ApiParam(value = "x값")
            @PathVariable int x,

            @ApiParam(value = "y값")
            @RequestParam int y) {
        return x+y;
    }

    @GetMapping("/user")
    public UserRes user(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }
}
