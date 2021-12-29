package ch21;

public class ObjectCopyTest {

    public static void main(String[] args) {

        Book[] library = new Book[5];
        Book[] copyLibrary = new Book[5];

        library[0] = new Book("개발자는 어떻게 되는 건가 1", "미오인");
        library[1] = new Book("개발자는 어떻게 되는 건가 2", "미오인");
        library[2] = new Book("개발자는 어떻게 되는 건가 3", "미오인");
        library[3] = new Book("개발자는 어떻게 되는 건가 4", "미오인");
        library[4] = new Book("개발자는 어떻게 되는 건가 5", "미오인");

        copyLibrary[0] = new Book();
        copyLibrary[1] = new Book();
        copyLibrary[2] = new Book();
        copyLibrary[3] = new Book();
        copyLibrary[4] = new Book();

        for (int i=0; i<library.length; i++){
            copyLibrary[i].setAuthor(library[i].getAuthor());
            copyLibrary[i].setTitle(library[i].getTitle());
        }

//        System.arraycopy(library, 0, copyLibrary, 0, 5);

//        System.out.println("== library==");
//        for (Book book:library){
//            System.out.println(book);
//            book.showInfo();
//        }
//
//        System.out.println("== copyLibrary==");
//        for (Book book:copyLibrary){
//            System.out.println(book);
//            book.showInfo();
//        }

        library[0].setAuthor("홍길동");
        library[0].setTitle("홍길동전");

        System.out.println("== library==");
        for (Book book:library){
            System.out.println(book);
            book.showInfo();
        }

        System.out.println("== copyLibrary==");
        for (Book book:copyLibrary){
            System.out.println(book);
            book.showInfo();
        }

    }
}
