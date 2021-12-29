package ch15;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {

    public static void main(String[] args) {

//        try (FileInputStream fis = new FileInputStream("reader.txt")) {
        try (FileReader fis = new FileReader("reader.txt")) {

            int i ;
            while ((i = fis.read()) != -1) {
                System.out.print((char)i);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
