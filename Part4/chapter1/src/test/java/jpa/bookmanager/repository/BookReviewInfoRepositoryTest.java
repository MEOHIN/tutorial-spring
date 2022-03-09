package jpa.bookmanager.repository;

import jpa.bookmanager.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired  // 주입
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired  // 의존성 추가
    private BookRepository bookRepository;

    /**
     * 북리뷰에 데이터가 정상적으로 추가하는 테스트
     */
    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>>> " + bookReviewInfoRepository.findAll());
    }

    @Test
    void crudTest2() {
        givenBook();        // 책 생성 (아이디 1)
        givenBookInfo();    // 책 추가 생성 + 그 책의 리뷰 생성 (아이디 2)

        /*    기존에는 bookId 를 가지고 bookRepository 에서 findById 로 데이터를 가져왔지만,
        이제는 BookReviewInfoRepository 에서 가져온 것에서 바로 getBook 으로 데이터를 직접 참조    */
        Book result = bookReviewInfoRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBook();

        System.out.println(">>>> " + result);

        BookReviewInfo result2 = bookRepository
                .findById(2L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

        System.out.println(">>>> " + result2);
    }
    private Book givenBook() {
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);

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