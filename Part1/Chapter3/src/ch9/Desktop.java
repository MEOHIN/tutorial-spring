package ch9;

public class Desktop extends Computer{

    @Override
    public void display() {
        System.out.println("Desktop Display");
    }

    @Override
    public void typing() {
        System.out.println("Desktop Typing");
    }

    @Override
    public void turnOn() {
        System.out.println("Desktop TurnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("Desktop TurnOn");
    }
}
