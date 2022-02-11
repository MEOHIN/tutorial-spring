package jpa.bookmaker.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/*
히스토리 데이터는 DB에 특정 데이터가 수정되면 해당 값의 복사본을 다른 테이블에 저장하는 경우가 있다.
 */
@Entity
@NoArgsConstructor
@Data
@EntityListeners(value = MyEntityListener.class)
public class UserHistory implements Auditable{

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
