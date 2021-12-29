package ch23;

import java.util.ArrayList;

class FastLibrary {

    public ArrayList<String> shelf = new ArrayList<>();

    public FastLibrary() {
        shelf.add("개발자되기 1");
        shelf.add("개발자되기 2");
        shelf.add("개발자되기 3");
//        shelf.add("개발자되기 4");
//        shelf.add("개발자되기 5");
    }

    public synchronized String lendBook() throws InterruptedException {

        Thread t = Thread.currentThread();

        while (shelf.size() == 0) {
            System.out.println(t.getName() + " waiting start");
            wait();
            System.out.println(t.getName() + " waiting end");
        }

        if (shelf.size() > 0) {
            String book = shelf.remove(0);
            System.out.println(t.getName() + ": " + book + " lend ");
            return book;
        } else {
            return null;
        }
    }

    public synchronized void returnBook(String book) {
        Thread t = Thread.currentThread();

        shelf.add(book);
        notifyAll();
        System.out.println(t.getName() + ": " + book + " return ");
    }
}


class Student extends Thread {

    public Student(String name) {
        super(name);
    }

    public void run() {

        try {
            String title = LibraryMain.library.lendBook();
            if (title == null) {
                System.out.println(getName() + "빌리지 못했습니다.");
                return;
            }
            sleep(5000);
            LibraryMain.library.returnBook(title);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}

public class LibraryMain {

    public static FastLibrary library = new FastLibrary();

    public static void main(String[] args) {

        Student std1 = new Student("std 1");
        Student std2 = new Student("std 2");
        Student std3 = new Student("std 3");
        Student std4 = new Student("std 4");
        Student std5 = new Student("std 5");

        std1.start();
        std2.start();
        std3.start();
        std4.start();
        std5.start();

    }
}