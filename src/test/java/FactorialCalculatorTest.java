import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @BeforeClass(description = "Тестирование класса FactorialCalculator", alwaysRun = true)
    private void setUp(){
        FactorialCalculator factorialCalculator = new FactorialCalculator();
    }

    @Test(description = "Тест с использованием 0", alwaysRun = true)
    void testCalculateFactorialWithZero() {
        int number = 0;
        long expectedFactorial = 1;
        long actualFactorial = FactorialCalculator.calculateFactorial(number);
        Assert.assertEquals(actualFactorial, expectedFactorial);
    }

    @Test(description = "Тест с использованием 1", alwaysRun = true)
    void testCalculateFactorialWith1() {
        int number = 1;
        long expectedFactorial = 1;
        long actualFactorial = FactorialCalculator.calculateFactorial(number);
        Assert.assertEquals(actualFactorial, expectedFactorial);
    }

    @Test(description = "Тест с использованием числа 12", alwaysRun = true)
    void testFactorialCalculatorWith12() {
        int number = 12;
        long expectedFactorial = 479001600;
        long actualFactorial = FactorialCalculator.calculateFactorial(number);
        Assert.assertEquals(actualFactorial, expectedFactorial);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, description = "Тест с отрицательным числом")
    void testCalculateFactorialWithNegativeNumber() {
        int number = -15;
        FactorialCalculator.calculateFactorial(number);
    }
}
