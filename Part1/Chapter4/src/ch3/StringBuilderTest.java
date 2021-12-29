package ch3;

public class StringBuilderTest {

    public static void main(String[] args) {
        String java = new String("Java");
        String android = new String("Android");

        StringBuilder buffer = new StringBuilder(java);
        System.out.println(System.identityHashCode(buffer));
        buffer.append(android);
        System.out.println(System.identityHashCode(buffer));


        String test = buffer.toString();
        System.out.println(test);
    }
}
