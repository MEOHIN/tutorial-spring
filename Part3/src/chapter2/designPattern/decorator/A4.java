package chapter2.designPattern.decorator;

public class A4 extends AudiDecorator {
    public A4(InterfaceCar audi, String modelName) {
        super(audi, modelName, 2000);
    }
}
