package post.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import post.dto.PostRequestDto;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class PostApiController {

/**     <경우 >     */
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {

        /* 아래 코드와 동일
        requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println("key: " + stringObjectEntry.getKey());
            System.out.println("value: " + stringObjectEntry.getValue());
        });
         */
        requestData.forEach((key, value) -> {
            System.out.println("key: " + key);
            System.out.println("value: " + value);
        });
    }

/**     <경우 2>
 *      DTO 객체를 만들어서 매핑
 *      package post.dto 의 PostRequestDto 클래스 참고
 */
    @PostMapping("/post2")
    public void post2(@RequestBody PostRequestDto requestData) {
        System.out.println(requestData);
    }

/**     <경우 3>
 *      java 에서는 camel case 이고 json 에서는 snake case 인 경우
 *          또는 대문자로만 이루어진 약어를 사용하는 경우
 *      package post.dto 의 PostRequestDto 클래스 참고
 *          @JsonProperty("snake case name") 직접 매칭
 */

}
