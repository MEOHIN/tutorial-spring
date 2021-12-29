package chapter2.designPattern.singleton;

public class SocketClient {

    private static SocketClient socketClient = null;

//    public SocketClient() {
        private SocketClient() {


}

    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
