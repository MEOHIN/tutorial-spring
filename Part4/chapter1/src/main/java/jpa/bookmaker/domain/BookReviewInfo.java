package jpa.bookmaker.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity     // entity 로 지정
@NoArgsConstructor  // entity 는 파라미터가 없는 생성자가 필요
@Data   // getter setter 를 편히 사용할 수 있게 함
// 상속받는 슈퍼클래스(= 부모클래스 = BaseEntity)의 정보를 ToString 에 포함하도록 함
@ToString(callSuper = true) // ToString 의 callSuper 가 default 로 false 이기 때문에
@EqualsAndHashCode(callSuper = true)    // EqualsAndHashCode 의 callSuper 가 default 로 false 이기 때문에
public class BookReviewInfo extends BaseEntity {    // extends BaseEntity 를 통해 기존해 선언한 생성시간과 수정시간을 받아올 수 있음
    @Id // Entity 는 PK 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    private Long id;

// Book 과 BookReviewInfo 를 연결용
//    private Long BookId;
/*  1:1 로 연관관계 매핑 -> table 에는 BookId 라는 값이 Long 타입으로 존재하겠지만, JPA 에서는 entity 로 set get 을 하면 관계를 자동으로 맺을 수 있도록 처리해준다.
    optional 의 default 는 true 이고, false 로 설정하면 null 을 허용하지 않는다는 뜻    */
    @OneToOne(optional = false)
    private Book book;

    /*
    float 과 Float, int Integer 의 차이
    float, int 는 null 값을 허용하지 않는다.
    Float, Integer 는 null 값을 허용하므로, nullPointException 사항에 대비하기위해 null 체크를 해야한다.
     */

//    평균 리뷰 평점
    private float averageReviewScore;

//    리뷰 수
    private int reviewCount;
}
