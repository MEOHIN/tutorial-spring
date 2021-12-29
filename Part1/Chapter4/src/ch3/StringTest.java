package ch3;

public class StringTest {

    public static void main(String[] args) {

        String java = new String("Java");
        String android = new String("Android");

        System.out.println(System.identityHashCode(System.identityHashCode(java)));
        java = java.concat(android);

//        System.out.println(java);
        System.out.println(System.identityHashCode(java));
    }
}
