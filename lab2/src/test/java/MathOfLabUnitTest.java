import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class MathOfLabUnitTest {

    MathOfLab math = spy(new MathOfLab());

    @Test
    void testCos() {
        double x = 0;
        when(math.sin(x)).thenReturn(0.0);
        assertEquals(1, math.cos(x), BasicTest.ALLOWED_PRECISION);

        x = Math.PI/2;
        when(math.sin(x)).thenReturn(1.0);
        assertEquals(0, math.cos(x), BasicTest.ALLOWED_PRECISION);
    }

    @Test
    void testTan() {
        double x = 10;
        when(math.sin(x)).thenReturn(-0.544021110889);
        when(math.cos(x)).thenReturn(-0.839071529076);
        assertEquals(0.648360827459, math.tan(x), BasicTest.ALLOWED_PRECISION);
    }

    @Test
    void testCotan() {
        double x = -3;
        when(math.sin(x)).thenReturn(-0.14112000806);
        when(math.cos(x)).thenReturn(-0.9899924966);
        assertEquals(7.01525255143, math.cotan(x), BasicTest.ALLOWED_PRECISION);
    }

    @Test
    void testSec() {
        double x = 45;
        when(math.cos(x)).thenReturn(0.525321988818);
        assertEquals(1.9035944074, math.sec(x), BasicTest.ALLOWED_PRECISION);
    }

    @Test
    void testCosec() {
        double x = -8;
        when(math.sin(x)).thenReturn(-0.989358246623);
        assertEquals(-1.0107562184, math.cosec(x), BasicTest.ALLOWED_PRECISION);
    }

    @Test
    void testLog() {
        int base = 3;
        double x = 81;

        when(math.ln(base)).thenReturn(1.09861228867);
        when(math.ln(x)).thenReturn(4.39444915467);
        assertEquals(4, math.log(base, x), BasicTest.ALLOWED_PRECISION);
    }
}