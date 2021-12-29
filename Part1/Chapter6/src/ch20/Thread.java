package ch20;

/**     Tread 란
 *      하드디스크, CPU, 메모리가 있다.
 *      프로그램은 '하드디스크' 에 저장된다.
 *      예를 들어 엑셀을 더블클릭하면 '메모리' 에 올라간다 = 프로그램이 메모리를 차지하고 있는 상태 = 프로그램이 메모리 공간을 갖고 있는 상태 = 이 상태를 '프로세스' 라고 한다.
 *      엑셀이 수행이 되려면 'CPU' 를 점유해야 한다. = CPU 에서 수행된다
 *      CPU 점유하는 단위 = Thread = 실제 작업 단위 = 모든 실행은 Thread 기반
 *      하나의 프로그램이 돌아간다 = 하나 이상의 Thread 가 있다.
 *      Thread 가 CPU 를 차지하면 수행이 된다.
 *      1개의 프로그램은 1개의 프로세스가 되고, 1개의 프로세스가 수행되기 위해서는 1개의 Thread 가 생긴다.
 *          가끔 하나의 프로그램에서 2가지가 동시에 수행이되는 듯이 보이는 현상이 있다.
 *          예: 프로그램을 다운받으면서 입력을 받는 경우, 프로그램을 다운받으면서 다른 화면을 진행하는 경우
 *              -> 동시에 수행되는 것이 아님: multi Thread (=Thread 2개) 가 CPU 를 점유했다가 내려왔다가 switch 되면서 일어나는 작업으로, CPU 의 스케쥴러 Thread 에게 CPU 를 배분해주는 것이다.
 *      스케줄러 Thread 들을 골고루 배분한다.
 *
 *      웹 프로그래밍에서는 직접 multi Thread 를 직접 구현할 일이 없다: web server 자체가 multi Threading 이 구현돼 있어서 request 가 들어오면 Thread 를 생성해서 request 들을 처리
 *      안드로이드에서 Thread 직접 처리해야하는 상황이 있음
 *
 *
 *      Thread 는 각자 개별적으로 소유한 Resource (= 변수, 메모리 등) 를 가짐 = context
 *      Thread 가 공유하는 자원: shared resource
 *      thread 끼리 switch 되는 상황에서 공유자원이 문제가 되는 경우가 발생한다 = 공유자원에 대해 경쟁이 발생
 *      공유자원 경쟁이 발생하는 부분을 critical section 이라고 한다.
 *      공유자원은 보호를 해줘야한다 = 동기화를 해야한다 ( 버전 관리 시스템과 유사 ) = 공유자원을 순차적으로 사용할 수 있도록 함
 *          예: 어떤 Thread 가 공유 자원을 사용중이라면 다른 Thread 에서 사용하지 못하도록 Rock 하고, 공유자원을 다 사용하면 Rock 을 해제
 *      JAVA 에서 동기화를 해주는 방식: synchronized method, synchronized block
 *      semaphore: semaphore 를 가진 Thread 만 critical section 에 진입할 수 있다.
 *
 *      자바 Thread 만드는 방법: Thread 클래스 상속하여 만들기, Runnable 인터페이스 구현해서 만들기
 *
 *      Thread Status
 *          Thread 시작
 *          start 가 불리는 순간, Thread pool 로 Thread 가 들어온다: CPU 배분을 기다리고 있는 상태 = Runnable : Thread pool 에 있는 Threa 들은 CPU를 배부받으면 언제든지 수행될 수 있는 상태
 *          Thread 가 모두 수행되고 종료된 상태 = Dead
 *          자바에서 Thread 가 not Runnable 상태가 되는 경우를 만드는 메소드: sleep(시간), wait(), join()
 *              sleep(시간)   : 지정한 시간이 지나면 Runnable 상태가 된다..
 *              wait()      : 리소스가 한정돼있고 여러 Thread 가 있을 때, 리소스가 유효할 때까지 기다리게 한다.
 *                  -> 리소스가 유효한 상태가 되면 프로그램에서 notify() 해주면 wait()로 인해 not Runnable 상태의 Thread 중 1개가 Runnable 상태가 된다.
 *                  -> 리소스가 유효한 상태가 되지 않으면 not Runnable 된 Thread 는 좀비 상태가 된다.
 *              join()      : 2 개의 Thread 가 돌고 있을 때 (a Thread 와 b Thread 라 하자), a Thread 가 b Thread 의 결과를 참조하는 경우에 a Thread 는 join()을 호출하게 되면, a Thread 자기 자신이 not Runnable 상태가 된다.
 *                  -> b Thread 가 종료되면 (= when other thread exits) Runnable 상태가 된다.
 *                  -> b Thread 가 종료되지 않으면 (무한루프에 빠지는 등의 문제로) a Thread 는 좀비 상태가 된다.
 *                  joinAll()을 권장
 *
 *      Thread 종료
 *      Flag: 무한루프를 돌릴 때, 의도적으로 멈춰야할 때가 생기는 경우 사용
 */
