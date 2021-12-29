package ch10;

public abstract class Car {

    public abstract void drive();
    public abstract void stop();
    public abstract void wiper();

    public void startCar(){
        System.out.println("시동을 켭니다.");
    }

    public void turnOff(){
        System.out.println("시동을 끕니다.");
    }

    public void washCar(){} //추상메서드가 아님, 구현부가 없는 함수일 뿐이다: 훅메서드라고도 함 -> 재정의할 때 사용할 수 있는 함수

    final public void run(){

        startCar();
        drive();
        stop();
        turnOff();
        washCar();
    }
}
