package ch21;

public class JoinTest extends Thread{

    int start;
    int end;
    int total;

    public JoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {

        int i;
        for (i = start; i<=end; i++) {
            total += i;
        }
    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread() + "start");

        JoinTest jt1 = new JoinTest(1, 50);
        JoinTest jt2 = new JoinTest(51, 100);

        jt1.start();
        jt2.start();
/**
//        start() 구문 다음에 있기는 하지만, 이 시점에서는 아직 jt1 과 jt2 의 수행이 끝나지 않았다.
//        그래서 이 시점에 lastTotal 은 0 이 할당됐다.
        int lastTotal = jt1.total + jt2.total;

//        이 시점에서는 jt1 과 jt2 의 수행이 끝났다.
        System.out.println("jt1.total = " + jt1.total);
        System.out.println("jt2.total = " + jt2.total);

//        그래서 lastTotal = 0 이 나오게 된다.
        System.out.println("lastTotal = " + lastTotal);
        System.out.println(Thread.currentThread() + "end");

//        어느 Thread 가 먼저 수행되는 지에 따라 결과 값이 계속 변할 수 있음
*/

//        not Runnable 상태가 지속되지 않기 위해 Interrupt 메소드를 사용한다. 이때 InterruptedException이 발생할 수 있다 -> try/catch
        try {
            jt1.join();
            jt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int lastTotal = jt1.total + jt2.total;

        System.out.println("jt1.total = " + jt1.total);
        System.out.println("jt2.total = " + jt2.total);

        System.out.println("lastTotal = " + lastTotal);
        System.out.println(Thread.currentThread() + "end");
    }}
