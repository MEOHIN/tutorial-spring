package ch19;

public class Mocha extends Decorator {

    public Mocha(Coffee coffee) {
        super(coffee);
    }

    public void brewing() {
        System.out.print(" Adding Chocolate \n");
    }
}
