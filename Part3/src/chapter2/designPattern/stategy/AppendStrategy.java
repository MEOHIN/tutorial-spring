package chapter2.designPattern.stategy;

public class AppendStrategy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        return "ABCD"+text;
    }
}
