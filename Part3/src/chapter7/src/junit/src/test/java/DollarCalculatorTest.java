import calculator.Calculator;
import calculator.DollarCalculator;
import calculator.MarketAPI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DollarCalculatorTest {

    @Test
    public void testHello() {
        System.out.println("hello");
    }

    @Test
    public void dollarTest() {
        MarketAPI marketApi = new MarketAPI();

        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);

        System.out.println(calculator.sum(10, 10));

        Assertions.assertEquals(22000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));

    }
}
