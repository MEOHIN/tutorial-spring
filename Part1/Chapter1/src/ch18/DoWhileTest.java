package ch18;

import java.util.Scanner;

public class DoWhileTest {

    public static void main(String[] args) {

        System.out.println("숫자를 입력해주세요: ");

        Scanner scanner = new Scanner(System.in);
        int input;
        int sum =0;

        do {
            input = scanner.nextInt();
            sum += input;
            System.out.println("숫자를 입력해주세요: ");
            System.out.println("0을 입력하면 연산이 완료됩니다.");
        }
        while (input != 0);
            System.out.println(sum);
    }
}