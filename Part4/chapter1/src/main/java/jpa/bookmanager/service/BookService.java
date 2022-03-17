package jpa.bookmanager.service;

import jpa.bookmanager.domain.Author;
import jpa.bookmanager.domain.Book;
import jpa.bookmanager.repository.AuthorRepository;
import jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor    // @Autowired 로 필드 주입하는 대신 @RequiredArgsConstructor 사용을 권장
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("martin");

        authorRepository.save(author);

        throw new RuntimeException("오류가 발생해서 commit 이 발생하지 않았습니다.");
    }
}
