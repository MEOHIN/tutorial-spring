package jpa.bookmaker.domain;

import lombok.*;

import java.time.LocalDateTime;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor          // 인자가 없는 생성자
@AllArgsConstructor         // 객체가 가지고 있는 모든 필드를 인자로 받아서 생성
@RequiredArgsConstructor    // 꼭 필요한 인자만을 받아서 생성 + @NoneNull
//@EqualsAndHashCode          // equals 메소드와 해시코드 메소드를 오버라이드
@Data                       // @Data = @Getter + @Setter + @ToString + @EqualsAndHashCode -> entity 객체를 사용하면서 가장많이 사용하는 어노테이션
@Builder                    // @AllArgsConstructor 처럼 객체를 생성하고 필드값을 주입해주는데, builder 형식
public class User {
    @NonNull    // 필수값 지정
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
