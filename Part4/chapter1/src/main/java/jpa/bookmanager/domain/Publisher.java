package jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Publisher extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "publisher_id")  // 중간 테이블을 없애기 위해 컬럼명을 명시적으로 설정
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();   // new ArrayList<>() 는 nullPointException 방지하기 위해 추가

    public void addBook(Book book) {
        this.books.add(book);
    }
}
