package ch15.shop;

public interface Buy {

    void buy();

    default void order(){

        System.out.println("buy order");
    }
}
