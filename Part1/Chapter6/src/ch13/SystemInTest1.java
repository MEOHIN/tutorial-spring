package ch13;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest1 {

    public static void main(String[] args) {

        System.out.println("알파벳 여러 개를 스고 [Enter]를 누르세요.");

        int i;

        try {
//            InputStreamReader: 바이트를 문자로 바꿔주는 클래스 -> 한글을 입력했을 때 깨지지 않도록 해줌
            InputStreamReader irs = new InputStreamReader(System.in);
            while ((i = irs.read()) != '\n') {
//                System.out.println(i);
                System.out.println((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
