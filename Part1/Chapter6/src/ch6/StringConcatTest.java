package ch6;

public class StringConcatTest {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "World";

        StringConcatImpl strImpl = new StringConcatImpl();
        strImpl.makeString("Hello" , "World");

//        내부적으로 익명 클래스가 만들어짐
//        람다식을 사용하려면 인터페이스에는 메서드를 1개만 만들어야 한다.
        StringConcat concat = (s, v) -> System.out.println(s + "," + v);
        concat.makeString(s1, s2);

/**     위 람다식에서 익명클래스가 만들어지는 과정은 아래와 같다.
        StringConcat concat2 = new StringConcat() {
            @Override
            public void makeString(String s1, String s2) {
                System.out.println(s + "," + v);
            }
        };

        concat2.makeString(s1, s2);
 */
    }
}
