package jpa.bookmaker.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(value = {AuditingEntityListener.class, UserEntityListener.class})    // createdAt 처럼 반복해서 메소드를 추가해야할때, Listener 를 지정해서 사용한다.
// table 에 name, catalog, schema 은 default 로 자동 지정되지만 따로 지정할 수도 있음. index 또는 uniqueConstraints 와 같은 제약사항은 실제 DB 적용 것과 다를 수 있다; 따라서 이런식으로 entity 에 표기하지 않고 DB 에 직접 설정해서 사용하는 편이다.
//@Table(
//        name = "user",
//        indexes = {@Index(columnList = "name")},
//        uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}
//)
public class User implements Auditable{
    /*  @GeneratedValue
    Long 타입의 값은 개발자가 직접 생성하는 것이 아닌 생성된 값(: table, sequence, identity, auto)을 쓰겠다는 의미
    IDENTITY: mysql DB 에서 많이 사용하는 전략: auto increment 값을 활용해서 이 generation 타입 제공. 트랜젝션이 종료되기전에 insert 문이 동작해서 id 값을 사전에 받아옴. 실제로 커밋되지 않고 로직이 종료된다 하더라도 DB 에서 가지고 있는 id 값을 증가시켜서 특정 id 값이 비는 현상이 발생하기도 함.
    SEQUENCE: oracle, h2 등에서 사용하는 전략: insert 구문이 실행될 때 sequence 로 부터 증가된 값을 받아서 실제 트렌젝션이 종료되는 시점에 id 를 채워서 query 함.
    TABLE: DB 종류와 상관없이 id 를 관리하는 별도의 table 을 만들 그 table 에서 id 값을 추출해서 사용.
    AUTO: 지정하지 않으면 사용되는 default 값. 각 DB 에 맞게 값을 설정함.
     */
    @Id     // primary key
    @GeneratedValue     // 순차적으로 데이터 증가.
    private Long id;

    @NonNull    // 필수값 지정
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING) // 적힌 순서로 자동 index 값이 매핑돼서 저장되는 것을 방지하기 위해 반드시 EnumType 을 string 으로 저장해야한다.
    private Gender gender;

    @Column(updatable = false)     // User 의 filed(=column) 에 속성을 지정하는 filed scope 의 annotation. 다양산 속성을 사용가능: 예를 들어 DB 의 컬럽과 Object 의 name 을 별도로 매핑할 땐, name 속성을 사용.
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

     /*
     Entity 는 Data 에 대한 객체이므로 DB 레코드 값을 그대로 반영.
     @Transient: 만약 객체로서의 역할만 하고 DB 에 반영하지 않고 DB 레코드와는 별개의 데이터를 갖고 싶을때 사용
      */
//    @Transient
//    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

    /*
    JPA 에서 제공하는 이벤트 7가지
     */
//    @PrePersist     // insert 메소드가 호출되기전 실행하는 메소드
//    public void prePersist() {
//        System.out.println(">>>> prePersist");
//    }
//
//    @PostPersist    // insert 메소드가 호출된 후의 실행하는 메소드
//    public void postPersist() {
//        System.out.println(">>>> postPersist");
//    }
//
//    @PreUpdate      // merge 메소드가 호출되기전 실행하는 메소드
//    public void preUpdate() {
//        System.out.println(">>>> preUpdate");
//    }
//
//    @PostUpdate     // merge 메소드가 호출된 후의 실행하는 메소드
//    public void postUpdate() {
//        System.out.println(">>>> postUpdate");
//    }
//
//    @PreRemove      // delete 메소드가 호출되기전 실행하는 메소드
//    public void preRemove() {
//        System.out.println(">>>> preRemove");
//    }
//
//    @PostRemove     // delete 메소드가 호출된 후의 실행하는 메소드
//    public void postRemove() {
//        System.out.println(">>>> postRemove");
//    }
//
//    @PostLoad       // select 조회가 일어난 직후에 실행되는 메소드
//    public void postLoad() {
//        System.out.println(">>>> postLoad");
//    }

//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
}
