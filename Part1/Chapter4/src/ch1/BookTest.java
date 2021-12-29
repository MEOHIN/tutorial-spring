package ch1;
// toString 메서드
class Book {

    private String title;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.title = author;
    }

    @Override
    public String toString() {
        return title + "," + author;
    }
}

public class BookTest {

    public static void main(String[] args) {

        Book book = new Book("데미안", "헤르만 허세");

        System.out.println(book);

        String str = new String("test");
        System.out.println(str.toString());
    }

}
