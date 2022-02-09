package jpa.bookmaker.domain;

import java.time.LocalDateTime;

/*
createdAt, updatedAt 같은 것을 계속 사용하기 위해서
createdAt, updatedAt 이 존재한다는 것을 알아야하기 때문에 만든 interface
 */
public interface Auditable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}
