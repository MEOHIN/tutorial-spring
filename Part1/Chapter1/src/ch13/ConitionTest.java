package ch13;

import java.util.Scanner;

public class ConitionTest {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        int num = scanner.nextInt();
//        System.out.println(num);
//
////        10 입력해보기

        int max;
        System.out.println("두 수를 입력 받아서 더 큰 수를 출력하세요\n");

        Scanner scanner = new Scanner(System.in);
        System.out.println("입력 1: ");
        int num1 = scanner.nextInt();
        System.out.println("입력 2: ");
        int num2 = scanner.nextInt();

        max = (num1 > num2)? num1 : num2;
        System.out.println(max);
//        숫자 입력해보기

    }
}
