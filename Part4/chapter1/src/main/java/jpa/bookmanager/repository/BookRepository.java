package jpa.bookmanager.repository;

import jpa.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();

    List<Book> findByCategoryIsNull();

    List<Book> findByDeletedFalse();

    List<Book> findByCategoryIsNullAndDeletedFalse();   // delete false 값을 항상 생성해서 사용해야한다.
}
