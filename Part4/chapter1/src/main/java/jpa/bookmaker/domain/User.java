package jpa.bookmaker.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor          // 인자가 없는 생성자
@AllArgsConstructor         // 객체가 가지고 있는 모든 필드를 인자로 받아서 생성
@RequiredArgsConstructor    // 꼭 필요한 인자만을 받아서 생성 + @NoneNull
//@EqualsAndHashCode          // equals 메소드와 해시코드 메소드를 오버라이드
@Data                       // @Data = @Getter + @Setter + @ToString + @EqualsAndHashCode -> entity 객체를 사용하면서 가장많이 사용하는 어노테이션
@Builder                    // @AllArgsConstructor 처럼 객체를 생성하고 필드값을 주입해주는데, builder 형식
@Entity                     // 객체를 entity 선언. 결국 entity 는 DB 테이블과 연결되는 JAVA 객체다. entity 는 반드시 Primary key 가 필요.
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})    // table 에 name, catalog, schema 은 default 로 자동 지정되지만 따로 지정할 수도 있음. index 또는 uniqueConstraints 와 같은 제약사항은 실제 DB 적용 것과 다를 수 있다; 따라서 이런식으로 entity 에 표기하지 않고 DB 에 직접 설정해서 사용하는 편이다.
public class User {

    @Id     // primary key
    /*  @GeneratedValue
    Long 타입의 값은 개발자가 직접 생성하는 것이 아닌 생성된 값(: table, sequence, identity, auto)을 쓰겠다는 의미
    IDENTITY: mysql DB 에서 많이 사용하는 전략: auto increase 값을 활용해서 이 generation 타입 제공. 트랜젝션이 종료되기전에 insert 문이 동작해서 id 값을 사전에 받아옴. 실제로 커밋되지 않고 로직이 종료된다 하더라도 DB 에서 가지고 있는 id 값을 증가시켜서 특정 id 값이 비는 현상이 발생하기도 함.
    SEQUENCE: oracle, h2 등에서 사용하는 전략: insert 구문이 실행될 때 sequence 로 부터 증가된 값을 받아서 실제 트렌젝션이 종료되는 시점에 id 를 채워서 query 함.
    TABLE: DB 종류와 상관없이 id 를 관리하는 별도의 table 을 만들 그 table 에서 id 값을 추출해서 사용.
    AUTO: 지정하지 않으면 사용되는 default 값. 각 DB 에 맞게 값을 설정함.
     */
    @GeneratedValue     // 순차적으로 데이터 증가.
    private Long id;

    @NonNull    // 필수값 지정
    private String name;

    @NonNull
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;
}
