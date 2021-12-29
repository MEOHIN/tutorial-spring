package ch6;

public class VIPCustomer extends Customer {

//    public VIPCustomer(){
////        super: 하위 클래스가 상위 클래스 인스턴스의 최소값을 가진다.
////                this와 마찬가지로 생성자를 호출
////        super();    // 디폴트 생성자 호출
////        상위 클래스를 호출하는 코드가 전혀없으면 super();를 굳이 작성하지 않아도 컴파일러가 자동으로 생성한다.
//
//        super(0, "no-name");
//
//        bonusRatio = 0.05;
//        salesRatio = 0.1;
//        customerGrade = "VIP";
//
//        System.out.println("VIPCustomer() call");
//    }

    double salesRatio;
    private String agentId;

    public VIPCustomer(int customerId, String customerName) {
        super(customerId, customerName);

        customerGrade = "VIP";
        bonusRatio = 0.05;
        salesRatio = 0.1;
    }

    @Override       //컴파일러에게 오버라이드 됐음을 알려주는 주석(;애노테이션:annotation)
    public int calcPrice(int price) {

        bonusPoint += price * bonusRatio;
        price -= (int)(price * salesRatio);
        return price;
    }

    public String getAgentId() {
        return agentId;
    }
}
