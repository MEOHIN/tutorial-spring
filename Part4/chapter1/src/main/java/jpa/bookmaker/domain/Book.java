package jpa.bookmaker.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // entity 는 기본 생성자가 필요, pk 필요
@NoArgsConstructor
@Data   // getter setter 생성
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
