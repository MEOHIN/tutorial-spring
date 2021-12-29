package ch1;


class OutClass {
    private int num = 10;
    private static int sNum =20;
    private InClass inClass;

    public OutClass(){
        inClass = new InClass();
    }

//    인스턴스 inner 클래스: outter 클래스가 생성된 후에 생성됨
    private class InClass {
        int iNum = 100;

//        static int sInNum = 500;  이너 클래스는 아우터 클래스가 만들어져야 만들어지므로, 이너클래스에서는 정젹변수(static)을 사용할 수 없다.

        void inTest(){
            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("OutClass iNum = " + iNum + "(내부 클래스의 인스턴스 변수)");

        }
    }

    public void usingClass(){
        inClass.inTest();
    }

//    정적 내부 클래스
    static class InStaticClass {

        int iNum = 100;
        static int sInNum = 200;

        void inTest(){
//           정적 클래스의 일반 메서드에서는 외부 클래스 인스턴스 변수를 사용할 수 없다.
//            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("InClass num = " + iNum + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass sNum = " + sInNum + "(내부 클래스의 인스턴스 변수)");
        }

        static void sTest(){
//            정적 클래스의 정적 메서드에서는 스태틱 변수만 호출할 수 없다.
//            System.out.println("InClass num = " + iNum + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass sNum = " + sInNum + "(내부 클래스의 인스턴스 변수)");
        }
    }
}

public class InnerTest {

    public static void main(String[] args) {
/**
        OutClass outClass = new OutClass();
        outClass.usingClass();

//        InClass가 private이 아닌 경우
//        OutClass.InClass inner = outClass.new InClass();
//        inner.inTest();
*/

        OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
        sInClass.inTest();

        System.out.println("=============");

        OutClass.InStaticClass.sTest();
    }
}
