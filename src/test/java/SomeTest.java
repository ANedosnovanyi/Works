import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SomeTest {

    private static int counter = 0;

    @BeforeEach
    public void beforeEach() {
        counter++;
    }

    @Test
    public void firstTest() {
        Assertions.assertEquals(1, counter);
    }

    @Test
    public void secondTest() {
        Assertions.assertEquals(0, counter);
    }

}
