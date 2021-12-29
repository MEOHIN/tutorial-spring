package ch9;
/*
추상 메서드 : 상위 클래스 본인은 구현하지 않을 테니, 하위 클래스에 구현을 위임하겠다는 무언의 의미를 가짐
 */
public abstract class Computer {

    abstract public void display();
    abstract public void typing();

    public void turnOn(){

        System.out.println("전원을 켭니다.");
    }

    public void turnOff(){
        System.out.println("전원을 끕니다.");
    }
}
