package ch3;

public class CustomerTest {

    public static void main(String[] args) {

        Customer customerLee = new Customer(10010, "LEE");
        customerLee.bonusPoint = 1000;
        System.out.println(customerLee.showInfo());

        VIPCustomer customerKim = new VIPCustomer(10020, "KIM");
        customerKim.bonusPoint = 10000;
        System.out.println(customerKim.showInfo());

//        VIPCustomer로 생성했지만 Customer 타입으로 대입하면서 VIPCustomer가 아닌 Customer로 형변환됨
        Customer vc = new VIPCustomer(12345, "noname");
    }
}
