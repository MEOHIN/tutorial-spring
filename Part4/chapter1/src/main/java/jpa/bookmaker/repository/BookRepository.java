package jpa.bookmaker.repository;

import jpa.bookmaker.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
