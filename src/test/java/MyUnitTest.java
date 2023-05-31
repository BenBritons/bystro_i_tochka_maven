import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyUnitTest {
    @Test
    public void testAddition() {
        int a = 2;
        int b = 3;
        int result = a + b;
        assertEquals(5, result);
    }

    @Test
    public void testDivision() {
        int a = 10;
        int b = 2;
        int result = a / b;
        assertEquals(5, result);
    }
}

