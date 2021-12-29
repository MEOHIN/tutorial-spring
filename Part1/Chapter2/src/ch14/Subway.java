package ch14;

public class Subway {

    String lineNum;
    int passengerCount;
    int money;

    public Subway(String lineNum){
        this.lineNum = lineNum;
    }

    public void take(int money){
        this.money = money;
        passengerCount++;
    }

    public void showSubwayInfo(){

        System.out.println(lineNum + "호선의 승객 수는 " + passengerCount + "명 이고, 수입은 " + money + "원 입니다.");
    }
}
