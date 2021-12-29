package put;

import org.springframework.web.bind.annotation.*;
import put.dto.PutRequestDto;

@RestController
@RequestMapping("/api")
public class PutApiController {

//    @PutMapping("/put")
//    public void put(@RequestBody PutRequestDto requestDto) {
//        System.out.println(requestDto);
//    }

/**        response 내려주는 방법
 *          RestController 의 경우, Object 자체를 return 시키면 spring boot 자체에서 object mapper 통해서  json 으로 바꿔준다.
 */
//    @PutMapping("/put")
//    public PutRequestDto put(@RequestBody PutRequestDto requestDto) {
//        System.out.println(requestDto);
//        return requestDto;
//    }

/**     path variable       */
    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long id) {
        System.out.println(id);
        return requestDto;
    }
}
