package chapter2.designPattern.decorator;

public class A5 extends AudiDecorator {
    public A5(InterfaceCar audi, String modelName) {
        super(audi, modelName, 3000);
    }
}
