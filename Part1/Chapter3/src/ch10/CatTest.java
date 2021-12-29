package ch10;

public class CatTest {

    public static void main(String[] args) {

        Car aiCar = new AICar();
        aiCar.run();

        System.out.println("===============");

        Car mnCar = new MenualCar();
        mnCar.run();
    }
}
