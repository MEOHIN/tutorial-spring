package ch9;

public class ComputerTest {

    public static void main(String[] args) {

//        Desktop desktop = new Desktop();
        Computer desktop = new Desktop(); //Computer 데이터타입도 사용가능
//        Computer computer = new Computer(); //추상 메서드는 인스턴스화 할 수 없다.
        desktop.display();
    }
}
