package ch9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**     try catch final
 *      예를 들어 파일을 열었는데, try catch가 끝나면 파일을 close 하고 싶을 때 사용
 *      try catch final 구문에서, try 구문이 일단 호출되면 finall은 무조건 호출된다.
 */
public class FileExceptionHandling {

    public static void main(String[] args) {

        FileInputStream fis = null;

//        try {
//            fis = new FileInputStream("a.txt");
//
//            System.out.println("read");
//
//            try {
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(e);
//            try {
//                fis.close();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }

        try {
            fis = new FileInputStream("a.txt");
            System.out.println("read");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finally");
        }
        System.out.println("end");
    }
}
