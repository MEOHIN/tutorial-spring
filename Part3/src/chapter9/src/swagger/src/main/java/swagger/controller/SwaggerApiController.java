package swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
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

    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 메소드")
    @GetMapping("/user")
    public UserRes user(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq req) {
        return new UserRes(req.getName(), req.getAge());
    }
}
