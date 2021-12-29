package ch15.shop;

public interface Sell {

    void sell();

    default void order(){

        System.out.println("sell order");
    }
}
