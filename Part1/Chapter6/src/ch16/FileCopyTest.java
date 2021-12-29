package ch16;

import java.io.*;
import java.net.Socket;

public class FileCopyTest {

    public static void main(String[] args) throws IOException {

        long millisecond = 0;

//        try (FileInputStream fis = new FileInputStream("a.zip");
//             FileOutputStream fos = new FileOutputStream("copy.zip")) {
//      Buffered~Stream 덕분에 속도가 단축됨
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.zip"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.zip"))) {

//            현재시간
            millisecond = System.currentTimeMillis();

            int i ;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }

            millisecond = System.currentTimeMillis() - millisecond;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(millisecond + "소모되었습니다.");

        Socket socket = new Socket();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        br.readLine();
    }
}
