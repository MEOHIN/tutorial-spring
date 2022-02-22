package jpa.bookmaker.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
User 와 Product 엔티티가 존재할 때, n대n 관계 즉 many-to-many 관계가 형성된다
이때 user_products 라는 중간 테이블이 생성되는데
user_products 는 order 라는 별개의 엔티티로 처리할 수 있다.
이를 author 와 book 의 관계로 설계
 */
@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookAndAuthor extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Author author;
}
