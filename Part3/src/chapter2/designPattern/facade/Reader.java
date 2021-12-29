package chapter2.designPattern.facade;

public class Reader {

    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String message = String.format("Reader %s 로 연결합니다.", fileName);
        System.out.println(message);
    }

    public void fileRead(){
        String message = String.format("Reader %s 의 내용을 읽어니다.", fileName);
        System.out.println(message);
    }

    public void fileDisconnect(){
        String message = String.format("Reader %s 연결을 종료합니다..", fileName);
        System.out.println(message);
    }
}
