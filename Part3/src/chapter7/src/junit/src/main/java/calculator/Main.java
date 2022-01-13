package calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello JUnit");

        MarketAPI marketApi = new MarketAPI();

        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);

        System.out.println(calculator.sum(10, 10));

    }
}
