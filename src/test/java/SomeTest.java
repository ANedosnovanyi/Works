import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SomeTest {

    private int number;

    @BeforeTest
    public void beforeTests() {
        number = 2;
    }

    @Test
    public void firstTest() {
        int factorial = FactorialCalculator.calculateFactorial(number);
        Assert.assertEquals(factorial, 4);
    }

    @Test
    public void secondTest() {
        int factorial = FactorialCalculator.calculateFactorial(number);
        Assert.assertEquals(factorial, 2);
    }

}
