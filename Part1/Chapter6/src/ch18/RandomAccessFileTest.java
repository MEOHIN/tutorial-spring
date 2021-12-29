package ch18;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    public static void main(String[] args) throws IOException {

        RandomAccessFile rf = new RandomAccessFile("random.txt", "rw");

//        int 는 4 바이트
        rf.writeInt(100);
        System.out.println("int 는 4byte");
        System.out.println("pos: " + rf.getFilePointer());
        System.out.println();

//        double 은 8 바이트
        rf.writeDouble(3.14);
        System.out.println("double 은 8byte, 누적 합산\n" + "int 4byte (100) + double 8byte (3.14) = 12byte");
        System.out.println("pos: " + rf.getFilePointer());
        System.out.println();

//        한글을 캐릭터당 3byte, String 은 맨 마지막에 null character 2byte 를 가짐
        rf.writeUTF("안녕하세요");
        System.out.println(
                "한글을 캐릭터당 3byte 이고 String 은 끝에 null character 2byte 를 가짐. 3byte * 5 + 2byte = 17byte, 누적 합산\n"
                        + "4byte (100) + 8byte (3.14) + 17byte (안녕하세요) = 29byte");
        System.out.println("pos: " + rf.getFilePointer());
        System.out.println();


//        seek(0): 읽기전에 file pointer 를 맨 앞으로 보냄
        rf.seek(0);

        int i = rf.readInt();
        double d = rf.readDouble();
        String str = rf.readUTF();

        System.out.println(i);
        System.out.println(d);
        System.out.println(str);

    }
}
