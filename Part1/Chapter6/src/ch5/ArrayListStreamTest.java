package ch5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

    public static void main(String[] args) {

        List<String> sList = new ArrayList<String>();
        sList.add("Tom");
        sList.add("James");
        sList.add("Edward");

        Stream<String> stream = sList.stream();
        stream.forEach(s -> System.out.println(s));

//        람다식은 보기엔 아무것도 없는것 같지만, 일반적으로 익명클래스가 구현된다.
        sList.stream().sorted().forEach(s -> System.out.println(s + "\t"));
        System.out.println("=================");
        sList.stream().map(s->s.length()).forEach(n -> System.out.println(n + "\t"));
        sList.stream().filter(s->s.length() >= 5).forEach(s -> System.out.println(s));
    }
}
