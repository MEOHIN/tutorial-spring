package ch3;

public class AddTest {

    public static void main(String[] args) {

        Add add1 = (x, y)-> x+y; // 아래와 동일한 식
        Add add2 = (x, y)->{return x+y;};

        System.out.println(add1.add(2, 3));
        System.out.println(add2.add(2, 3));

    }
}
