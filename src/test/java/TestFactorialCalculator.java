import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFactorialCalculator {

    public   FactorialCalculator factorialCalculator;

    @BeforeEach
    public void setUp() {
        factorialCalculator =  new FactorialCalculator();
    }

    @Test
    @DisplayName("Тест с использованием числа 12")
    void testFactorialCalculatorWith12() {
        int number = 12;
        long expectedFactorial = 479001600;
        long actualFactorial = FactorialCalculator.calculateFactorial(number);
        Assertions.assertEquals(actualFactorial, expectedFactorial, "Факториал для положительного числа " + number);
    }

    @Test
    @DisplayName("Тест с использованием 0")
    void testCalculateFactorialWithZero() {
        int number = 0;
        long expectedFactorial = 1;
        long actualFactorial = FactorialCalculator.calculateFactorial(number);
        Assertions.assertEquals(actualFactorial, expectedFactorial);
    }

    @Test
    @DisplayName("Тест с отрицательным числом")
    void testCalculateFactorialWithNegativeNumber() {
        int number = -10;
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculateFactorial(number));
    }

}
