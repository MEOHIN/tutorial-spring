package jpa.bookmaker.domain;

import jpa.bookmaker.domain.lietener.Auditable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
//@EntityListeners(value = AuditingEntityListener.class)
public class UserHistory extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;

//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
}
