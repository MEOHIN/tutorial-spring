package jpa.bookmaker.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // entity 는 기본 생성자가 필요, pk 필요
@NoArgsConstructor
@Data   // getter setter 생성
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    /*  bookReviewInfo 에서 book 의 데이터를 가져오는 상태에서
    *   book 에서 bookReviewInfo 데이터를 가져오도록 하는 방법 */
    @OneToOne(mappedBy = "book")  // entity relational 을 사용하는 경우 toString 메소드가 순환참조가 걸리게 된다.
    @ToString.Exclude   // 따라서 대부분 relational 을 단반향으로 걸거나 toString 에서 제외하는 처리기 필요
    private BookReviewInfo bookReviewInfo;  // book 에서 bookReviewInfo 데이터를 접근

    @OneToMany
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors = new ArrayList<>();
}
