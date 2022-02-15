package jpa.bookmaker.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity // entity 는 기본 생성자가 필요, pk 필요
@NoArgsConstructor
@Data   // getter setter 생성
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    private Long publisherId;
}
