package ch12;

public class LogicalTest {

    public static void main(String[] args) {

        int num1 = 10;
        int i = 2;

//        논리의 '곱'은 앞에 항이 false라면 뒤의 항을 진행하지 않는다
//        boolean value = ((num1 = num1 + 10) < 10) && ((i = i + 2) < 10);
//        boolean value = ((num1 = num1 + 10) > 10) && ((i = i + 2) < 10);
//        논리의 '합'은 앞에 항이 true라면 뒤의 항을 진행하지 않는다
//        boolean value = ((num1 = num1 + 10) < 10) || ((i = i + 2) < 10);
        boolean value = ((num1 = num1 + 10) > 10) || ((i = i + 2) < 10);

        System.out.println(value);
        System.out.println(num1);
        System.out.println(i);
    }
}
