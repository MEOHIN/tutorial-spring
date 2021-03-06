package jpa.bookmanager.repository;

import jpa.bookmanager.domain.Book;
import jpa.bookmanager.domain.Publisher;
import jpa.bookmanager.domain.Review;
import jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();

        User user = userRepository.findByEmail("martin@fastcampus.com");

        System.out.println("Review: " + user.getReviews());
        System.out.println("Book: " + user.getReviews().get(0).getBook());
        System.out.println("Publisher: " + user.getReviews().get(0).getBook().getPublisher());
    }


    /**
     * cascade 테스트
     */
    @Test
    void bookCascadeTest() {
        Book book = new Book();
        book.setName("JPA 초 격차 패키지");

        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");

        book.setPublisher(publisher);
        bookRepository.save(book);

        System.out.println("books:" + bookRepository.findAll());
        System.out.println("publisher: " + publisherRepository.findAll());

//        merge 이벤트 발생
        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("슬로우캠퍼스");

        bookRepository.save(book1);

        System.out.println("publisher: " + publisherRepository.findAll());

//        book entity 삭제
        Book book2 = bookRepository.findById(1L).get();
//        bookRepository.delete(book2);
//        bookRepository.deleteById(1L);

//        orphan removal test = 연관관계 제거
        Book book3 = bookRepository.findById(1L).get();
        book3.setPublisher(null);

        bookRepository.save(book3);

        System.out.println("books: " + bookRepository.findAll());
        System.out.println("publisher: " + publisherRepository.findAll());
    }

    /**
     *  cascade remove test
     */
    @Test
    void bookRemoveCascadeTest() {
//        삭제가 될 지 확인
        bookRepository.deleteById(1L);

//        data.sql 이 잘 추가 되었는지 확인
        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publisher : " + publisherRepository.findAll());

//        추가한 data.sql 연관관계가 ToString 에서 안나오는 것을 해결하기 위해 추가적으로 로그 찍기
        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    /**
     *  soft delete test
     *  id 값이 3번인 데이터를 삭제처리 했을 때, 조회하는 테스트
     */

    @Test
    void softDelete() {
        bookRepository.findAll().forEach(System.out::println);  // 삭제 여부와 관계없이 모든 데이터 노출
        System.out.println(bookRepository.findById(3L));    // id 로 조회해도 삭제된 3번 값을 가져옴

        bookRepository.findByCategoryIsNull().forEach(System.out::println);

        bookRepository.findByDeletedFalse().forEach(System.out::println);
        bookRepository.findByCategoryIsNullAndDeletedFalse().forEach(System.out::println);
    }

    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private User givenUser() {
        return userRepository.findByEmail("martin@fastcampus.com");
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("내 인생을 바꾼 책");
        review.setContent("너무너무 재미있고 즐거운 책이었어요.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 초 격차 패키지");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");

        return publisherRepository.save(publisher);
    }
}
