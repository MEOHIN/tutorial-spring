package ch6;

import java.util.ArrayList;

public class CustomerTest {

    public static void main(String[] args) {

        ArrayList<Customer> customerArrayList = new ArrayList<>();

        Customer customerT = new Customer(10010, "Tomas");
        Customer customerJ = new Customer(10010, "James");
        Customer customerE = new GoldCustomer(10010, "Edward");
        Customer customerA = new GoldCustomer(10010, "Alice");
        Customer customerW = new VIPCustomer(10010, "William");

        customerArrayList.add(customerT);
        customerArrayList.add(customerJ);
        customerArrayList.add(customerE);
        customerArrayList.add(customerA);
        customerArrayList.add(customerW);

        for (Customer customer : customerArrayList){
            System.out.println(customer.showInfo());
        }

        int price = 10000;
        for (Customer customer : customerArrayList){

            int cost = customer.calcPrice(price);
            System.out.println(customer.getCustomerName() + "님의 " + cost + "원을 지불하셨습니다.");
            System.out.println(customer.getCustomerName() + "님의 현재 보너스 포인트는 " + customer.bonusPoint + " 입니다.");
        }
    }
}
