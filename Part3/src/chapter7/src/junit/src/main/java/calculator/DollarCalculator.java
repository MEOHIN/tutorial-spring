package calculator;

public class DollarCalculator implements InterfaceCalculator {

    private int price = 1;

    public void  init() {
        this.price = connect();
    }

    public int connect() {
//        naver
//        kakao
        return 1100;
    }

    @Override
    public int sum(int x, int y) {
        return 0;
    }

    @Override
    public int minus(int x, int y) {
        return 0;
    }
}
