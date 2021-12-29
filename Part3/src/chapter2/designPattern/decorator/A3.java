package chapter2.designPattern.decorator;

public class A3 extends AudiDecorator {
    public A3(InterfaceCar audi, String modelName) {
        super(audi, modelName, 1000);
    }
}
