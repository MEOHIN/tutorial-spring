package ch9;
/**  예외처리 미루기
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {

    public Class localClass (String fileName, String className) throws ClassNotFoundException, FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Class c = Class.forName(className);
        return c;
    }

    public static void main(String[] args) {

        ThrowsException test = new ThrowsException();

        try {
            test.localClass("a.txt", "java.lang.String");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
//        default exception 은 try catch 구문 가장 마지막줄에 사용
        System.out.println("end");
    }
}
