package calculator;

public class DollarCalculator implements InterfaceCalculator {

    private int price = 1;
    private MarketAPI marketApi;

    public DollarCalculator(MarketAPI marketApi) {
        this.marketApi = marketApi;
    }

    public void  init() {
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }
}
