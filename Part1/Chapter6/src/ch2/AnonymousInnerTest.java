package ch2;


class Outer2 {

    int outNum = 100;
    static int sNum = 200;

//    Runnable: 클래스를 쓰레드화할 때 필요한 Run 메서드를 구현할 때 사용하는 인터페이스
    Runnable getRunnable(final int i) {

//        메서드 호출되면 스택에 메모리가 잡히고 메서드 호출이 끝나면 i 와 num 변수는 없어진다.
        final int num = 10;

//        지역 내부 클래스
//        class MyRunnable implements Runnable {
//        지역 내부 클래스에 굳이 이름을 지어주지 않고 사용할 수 있다.
        return new Runnable() {

            int localNum = 1000;

            @Override
            public void run() {

//                getRunnable 메서드 호출되는 시점과 MyRunnable 생성되는 시점이 달라서 재정의가 안된다.
//                run 메서드는 다시호출될 가능성이 있는데, 이 때 i 와 num 이 없을 수 있다.
//                따라서 스택에 메로리가 잡히면 안되기 떄문에 final 처리한다: 직접 final 처리르 하지 않더라도 컴파일러가 final 로 바꾼다. -> 상수메모리 (Constant area)에 잡힌다.
//                i = 50;
//                num = 20;

                System.out.println("i =" + i);
                System.out.println("num =" + num);
                System.out.println("localNum =" + localNum);

                System.out.println("outNum =" + outNum + "(외부 클래스 인스턴스 변수)");
                System.out.println("Outer2.sNum =" + Outer2.sNum + "(외부 클래스 정적 변수)");

            }
        };

//        return new MyRunnable();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Runnable class");
        }
    };
}

public class AnonymousInnerTest {

    public static void main(String[] args) {

        Outer2 out = new Outer2();
        Runnable runner = out.getRunnable(100);

        runner.run();

        out.runnable.run();
    }
}
