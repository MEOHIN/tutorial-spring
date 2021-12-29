package ch21;

public class BookTest {

    public static void main(String[] args) {

        Book[] library = new Book[5];

//        for (int i=0; i<library.length; i++){
//            System.out.println(library[i]);
//        }

        library[0] = new Book("개발자는 어떻게 되는 건가 1", "미오인");
        library[1] = new Book("개발자는 어떻게 되는 건가 2", "미오인");
        library[2] = new Book("개발자는 어떻게 되는 건가 3", "미오인");
        library[3] = new Book("개발자는 어떻게 되는 건가 4", "미오인");
        library[4] = new Book("개발자는 어떻게 되는 건가 5", "미오인");

        for (Book book:library){
            System.out.println(book);
            book.showInfo();
        }
    }
}
