package ch14;

public class Bus {

    int busNum;
    int passengerCount;
    int money;

    public Bus(int busNum){
        this.busNum = busNum;
    }

    public void take(int money){
        this.money = money;
        passengerCount++;
    }

    public void showBusInfo(){

        System.out.println(busNum + "번 버스의 승객 수는 " + passengerCount + " 명 이고, 수입은 " + money + "원 입니다.");
    }
}
