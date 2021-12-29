package ch15.bookstore;

public class BookShelfTest {

    public static void main(String[] args) {

        Queue bookQueue = new BookShelf();
        bookQueue.enQueue("개발자되기 1");
        bookQueue.enQueue("개발자되기 2");
        bookQueue.enQueue("개발자되기 3");
        bookQueue.enQueue("개발자되기 4");
        bookQueue.enQueue("개발자되기 5");

        System.out.println(bookQueue.getSize());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());

    }
}
