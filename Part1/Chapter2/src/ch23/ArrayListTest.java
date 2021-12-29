package ch23;

import ch21.Book;

import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList<Book> library = new ArrayList<>();

        library.add(new Book("개발자의 길 1 ", "미오인"));
        library.add(new Book("개발자의 길 2 ", "미오인"));
        library.add(new Book("개발자의 길 3 ", "미오인"));
        library.add(new Book("개발자의 길 4 ", "미오인"));
        library.add(new Book("개발자의 길 5 ", "미오인"));

        for (int i=0; i<library.size(); i++){
            library.get(i).showInfo();
        }
    }
}
