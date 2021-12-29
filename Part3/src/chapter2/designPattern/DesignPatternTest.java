package chapter2.designPattern;

import chapter2.designPattern.stategy.*;
import designPattern.stategy.*;

public class DesignPatternTest {
    public static void main(String[] args) {
/*  Singleton pattern
        AUsingSocketClient aClazz = new AUsingSocketClient();
        BUsingSocketClient bClazz = new BUsingSocketClient();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
 */
/*  Adapter pattern
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
//        connect(cleaner);
        Electronic110V hairdryerAdapter = new SocketAdapter(cleaner);
        connect(hairdryerAdapter);

        AirConditioner airconditioner = new AirConditioner();
        Electronic110V airconditionerAdapter = new SocketAdapter(airconditioner);
        connect(airconditionerAdapter);
 */
/*  Proxy pattern
//        Browser browser = new Browser("www.naver.com");
        InterfaceBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
 */
/*  AOP pattern: Proxy 패턴을 활용
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        InterfaceBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
                );

        aopBrowser.show();
        System.out.println("loading time: " + end.get());

        aopBrowser.show();
        System.out.println("loading time: " + end.get());
 */
/*  Decorator Pattern
        InterfaceCar audi = new Audi(1000);
        audi.showPrice();

//        a3
        InterfaceCar audi3 = new A3(audi, "A3");
        audi3.showPrice();

//        a4
        InterfaceCar audi4 = new A4(audi, "A4");
        audi4.showPrice();

//        a5
        InterfaceCar audi5 = new A5(audi, "A5");
        audi5.showPrice();
 */
/*
        Button button = new Button("버튼");

        button.addListener(new IntfcButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메세지전달: click 1");
        button.click("메세지전달: click 2");
        button.click("메세지전달: click 3");
        button.click("메세지전달: click 4");
        button.click("메세지전달: click 5");
*/
/*
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.fileWrite();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        FacadeSftpClient sftpClient = new FacadeSftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
 */
        Encoder encoder = new Encoder();

//        base64
        EncodingStrategy base64 = new Base64Strategy();

//        normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello, java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }

/*    Adapter - 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
 */

}
