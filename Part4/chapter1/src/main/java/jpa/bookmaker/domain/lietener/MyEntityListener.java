package jpa.bookmaker.domain.lietener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/*
로직 공통적인 부분에 대해서 listener 를 하나만 구현하고도 여러곳에서 사용할 수 있다.
 */
public class MyEntityListener {
    @PrePersist
    public void prePersist(Object o) {  // Entity 객체에서는 파라미터를 받지 않아도 this 의 값이라서 Object 를 확인할 수 있지만, Listener 해당 Entity 를 받아서 처리해야하므로 Object 파라미터를 받아야 한다.
        if (o instanceof  Auditable) {  // 해당 객체가 Auditable 객체인지 확인
            ((Auditable) o).setCreatedAt(LocalDateTime.now());
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object o) {
        if (o instanceof  Auditable) {
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }
}
