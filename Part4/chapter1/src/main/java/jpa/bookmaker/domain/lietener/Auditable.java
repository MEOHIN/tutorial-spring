package jpa.bookmaker.domain.lietener;

import java.time.LocalDateTime;

/*
createdAt, updatedAt 처럼 로직 공통적인 부분에 대해서 listener 를 하나만 구현하고도 여러곳에서 사용할 수 있다.
그러러면 createdAt, updatedAt 이 존재한다는 것을 알아야하기 때문에 만든 interface
 */
public interface Auditable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}
