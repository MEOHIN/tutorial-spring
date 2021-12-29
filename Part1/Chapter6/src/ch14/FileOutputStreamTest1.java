package ch14;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest1 {

    public static void main(String[] args) {

        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
//            65 는 ASKII 표현으로 'A'
            fos.write(65);
            fos.write(65);
            fos.write(65);

        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("end");
    }
}
