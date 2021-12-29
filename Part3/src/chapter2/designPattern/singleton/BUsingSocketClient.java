package chapter2.designPattern.singleton;

public class BUsingSocketClient {

    private SocketClient socketClient;

    public BUsingSocketClient() {
//        this.socketClient = new SocketClient();
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
