package chapter2.designPattern.observer;

public class Button {

    private String name;
    private IntfcButtonListener buttonListener;

    public Button(String name) {
        this.name = name;
    }

    public void click(String message) {
        buttonListener.clickEvent(message);
    }

    public void addListener(IntfcButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}
