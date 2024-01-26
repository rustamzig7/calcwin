package JavaWindows;

import static org.junit.Assert.*;

import org.junit.Test;

public class WindowCalculatorTest {




    @Test
    public void testGetResultTypeInt() {
        WindowCalculator calculator = new WindowCalculator();

        // Test case 1
        int resultTypeInt1 = calculator.getResultTypeInt("Односекционное");
        assertEquals(1, resultTypeInt1);

        // Test case 2
        int resultTypeInt2 = calculator.getResultTypeInt("Трехсекционные");
        assertEquals(3, resultTypeInt2);
    }



}
