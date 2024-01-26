package JavaWindows;

import static org.junit.Assert.*;

import org.junit.Test;

public class WindowCalculatorTest {




    @Test
    public void testGetResultTypeInt() {
        WindowCalculator calculator = new WindowCalculator();

        int resultTypeInt1 = calculator.getResultTypeInt("Односекционное");
        assertEquals(1, resultTypeInt1);

        int resultTypeInt2 = calculator.getResultTypeInt("Трехсекционные");
        assertEquals(3, resultTypeInt2);
    }

    @Test
    public void testGetHeightAndWidthPrice() {
        WindowCalculator calculator = new WindowCalculator();

        Pair result1 = calculator.getHeightAndWidthPrice("Эконом");
        assertEquals(1, result1.first);
        assertEquals(2, result1.second);

        Pair result2 = calculator.getHeightAndWidthPrice("Премиум");
        assertEquals(3, result2.first);
        assertEquals(3, result2.second);
    }

}
