package jpa.bookmanager.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String country;

    /*
    many to many 는 PK 를 정하기 어려워서 중간테이블을 생성하고 author_id 와 books_id 를 서로 매핑하게 된다.
    따라서 one to many 관계에서는 중간 테이블을 제거하고 직접 참조하도록 했었지만, many to many 는 중간테이블 없이 직접참조할 수 없다.
    현업에서는 many-to-many 는 아주 특별한 상황이 아니라면 거의 사용하지 않는다.
     */
//    @ManyToMany
//    @ToString.Exclude
//    private List<Book> books = new ArrayList<>();
//
//    public void addBook(Book... book) {     // ... 은 배열로 받는 다는 의미
//        Collections.addAll(this.books, book);
//    }

    @OneToMany
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    public void addBookAndAuthors(BookAndAuthor... bookAndAuthors) {     // ... 은 배열로 받는 다는 의미
        Collections.addAll(this.bookAndAuthors, bookAndAuthors);
    }
}
