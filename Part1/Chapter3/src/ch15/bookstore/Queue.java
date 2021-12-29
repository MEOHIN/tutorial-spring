package ch15.bookstore;

public interface Queue {

    void enQueue(String title);
    String deQueue();

    int getSize();

}
