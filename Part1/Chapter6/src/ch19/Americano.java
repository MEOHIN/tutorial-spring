package ch19;

public class Americano extends Decorator {
    public Americano(Coffee coffee) {
        super(coffee);
    }

    public void brewing() {
        super.brewing();
        System.out.print(" Adding Water \n");
    }
}
