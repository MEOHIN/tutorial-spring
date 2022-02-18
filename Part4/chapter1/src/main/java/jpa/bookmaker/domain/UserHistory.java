package jpa.bookmaker.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/*
히스토리 데이터는 DB에 특정 데이터가 수정되면 해당 값의 복사본을 다른 테이블에 저장하는 경우가 있다.
 */
@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(value = AuditingEntityListener.class)
public class UserHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", insertable = false, updatable = false) // 컬럼 이름을 명시적으로 설정
    private Long userId;

    private String name;

    private String email;

    @ManyToOne
    private User user;
}
