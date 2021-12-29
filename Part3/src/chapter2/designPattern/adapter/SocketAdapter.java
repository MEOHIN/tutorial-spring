package chapter2.designPattern.adapter;

public class SocketAdapter implements Electronic110V {

    private Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        System.out.println("adapter trans 110V to 220V");
        electronic220V.connect();
    }
}
