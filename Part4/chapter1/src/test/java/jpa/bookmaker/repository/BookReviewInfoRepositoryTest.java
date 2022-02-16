package jpa.bookmaker.repository;

import jpa.bookmaker.domain.Book;
import jpa.bookmaker.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired  // 주입
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired  // 의존성 추가
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>>> " + bookReviewInfoRepository.findAll());
    }

    @Test
    void crudTest2() {
        givenBook();
        givenBookInfo();

        /*    기존에는 bookId 를 가지고 bookRepository 에서 findById 로 데이터를 가져왔지만,
        이제는 BookReviewInfoRepository 에서 가져온 것에서 바로 getBook 으로 데이터를 직접 참조    */
        Book result = bookReviewInfoRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBook();

        System.out.println(">>>> " + result);
    }
    private Book givenBook() {
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        return bookRepository.save(book);
    }

    private void givenBookInfo() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>>> " + bookReviewInfoRepository.findAll());
    }
}