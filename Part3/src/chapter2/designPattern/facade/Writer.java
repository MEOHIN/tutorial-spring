package chapter2.designPattern.facade;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect(){
        String message = String.format("Writer %s 로 연결합니다.", fileName);
        System.out.println(message);
    }

    public void fileDisconnect(){
        String message = String.format("Writer %s 로 연결을 종합니다.", fileName);
        System.out.println(message);
    }

    public void fileWrite(){
        String message = String.format("Writer %s 로 파일쓰기를 합니다.", fileName);
        System.out.println(message);
    }
}
