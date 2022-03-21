package jpa.bookmanager.service;

import jpa.bookmanager.domain.Author;
import jpa.bookmanager.domain.Book;
import jpa.bookmanager.repository.AuthorRepository;
import jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor    // @Autowired 로 필드 주입하는 대신 @RequiredArgsConstructor 사용을 권장
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final AuthorService authorService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        authorService.putAuthor();

        throw new RuntimeException("오류가 발생해서 commit 이 발생하지 않았습니다.");    // rollback
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void get(Long id) {
        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        entityManager.clear();

        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        bookRepository.update();

        entityManager.clear();

//        Book book = bookRepository.findById(id).get();  // book 이라는 entity 는 uncommitted 데이터를 가지고 있음
//        book.setName("바뀔까?");
//        bookRepository.save(book);
    }
}
