package ch14;
/*
1. James 와 Tomas 는 각각 버스와 지하철을 타고 학교에 갑니다.
2. James 는 5000원을 가지고 있었고, 100번 버스를 타면서 1000원을 지불합니다.
3. Tomas 는 10000원을 가지고 있었고, 초록색 지하철을 타면서 1200원을 지불합니다.
 */

public class StudentTest {

    public static void main(String[] args) {

        Student studentJ = new Student("James", 5000);
        Student studentT = new Student("Tomas", 10000);

        Bus bus100 = new Bus(100);
        Bus bus200 = new Bus(200);
        Subway subwayG = new Subway("Green");
        Subway subwayR = new Subway("Red");

        studentJ.takeBus(bus100);
        studentT.takeSubway(subwayR);

        studentJ.showInfo();
        studentT.showInfo();

        bus100.showBusInfo();
        subwayR.showSubwayInfo();
    }
}
