package get.controller;

import get.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/get")    // http://localhost:8080/api/get/hello
    public String hello() {
        return "get Hello";
    }

//    위의 GetMapping 과 동일하지만,
//    RequestMapping 은 옛날 방식: get, put.. 등 모든 메소드가 매핑됨 ->
//    매핑하고 싶은 메소드를 지정할 때: method
    @RequestMapping(path = "/hi", method = RequestMethod.GET)   //http://localhost:8080/api/get/hi
    public String hi() {
        return "hi";
    }

/**     <Path Variable>      */
//    http://localhost:8080/api/get/path-variable/{변하는값 ex: name, age...etc}
//    @GetMapping("/path-variable/{name}")
//    public String pathVariable(@PathVariable String name){
//        System.out.println("PathVariable: " + name);
//        return name;
    /**    파라미터 변수의 이름(ex: name)과 GetMapping 속성의 이름(ex: name)이 동일해야한다.
     *      또는 이름을 일치 시켜줄 수 없을 경우
     *          @GetMapping("/path-variable/{name}")
     *          public String pathVariable(@PathVariable(name = "name") String pathName){
     *          System.out.println("PathVariable: " + pathName);
     */
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable: " + pathName);
        return pathName;
    }

/**     <Query Parameter> 스프링부트에서 query parmeter 를 처리하는 방법 1
 *      형태: ...?key1=value1&key2=value2&key3=value3&key4=value&....
 */
//    http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " +entry.getValue() + "\n");
        });

        return sb.toString();
    }

/**     <Query Parameter> 스프링부트에서 query parmeter 를 처리하는 방법 2    */
//    위와 동일하지만, Map은 뭐든 다 받을 수 있음
//    명시적으로 변수로 받을 경우
    @GetMapping("query-param2")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + "\n" + email + "\n" + age;
    }

/**     <Query Parameter> 스프링부트에서 query parmeter 를 처리하는 방법 3
 *      DTO(Data Transfer Object) 형태로 매핑: 객체를 만들어서 query parameter 바로 매핑되도록 함
 *      package hello.dto 의 UserRequest 클래스 참고
 *      가장 활용도가 높아 자주 사용됨
 */
    @GetMapping("query-param3")
//    @RequestParam 어노테이션을 붙이지 않음
//    정의해둔 DTO 에서 query parameter key 이름과 객체의 변수 이름이 일치해야 한다.
    public String queryParam3(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
