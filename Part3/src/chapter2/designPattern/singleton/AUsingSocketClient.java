package chapter2.designPattern.singleton;

public class AUsingSocketClient {

    private SocketClient socketClient;

    public AUsingSocketClient() {
//        this.socketClient = new SocketClient();
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
