package validation.filter.dto;

import lombok.*;

//@Getter     // 변수의 get method 생성
//@Setter     // 변수의 set method 생성
@Data       // getter method, setter method, toString, hashcode 까지 생성
@NoArgsConstructor      // 기본 생성자
@AllArgsConstructor     // 전체 생성자
public class User {

    private String name;
    private int age;
}
