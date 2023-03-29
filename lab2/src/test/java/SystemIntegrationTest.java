
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemIntegrationTest {

    public static final double STEP = 0.01;
    SystemMath system = new SystemMath(new MathOfLab());

    @ParameterizedTest
    @ValueSource(doubles={-0.587, -4.175, -5.536, -2.256})
    void testSpecialPoints(double x) {
        double left = system.calculateFunction(x - STEP);
        double right = system.calculateFunction(x + STEP);
        double res = system.calculateFunction(x);
        System.out.println(left);
        System.out.println(right);
        System.out.println(res);
        assertTrue((res > left && res > right) || (res < left && res < right));
    }

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void generalTest(double x, double expected) {
        assertEquals(expected, system.calculateFunction(x), BasicTest.ALLOWED_PRECISION);
    }

    static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.of(2, 3.478529378620244E-5),
                Arguments.of(234, 9.950872217726572E13),
                Arguments.of(12, 3.2297855884941246E7),
                Arguments.of(-7, 5.6150692826732875),
                Arguments.of(0.085, -2.7742917807036582E7),
                Arguments.of(-0.4307, 15.636719295880448),
                Arguments.of(-0.4307 - 2*Math.PI, 15.636720268436083),
                Arguments.of(-0.892, 16.59589599509553)
        );
    }

}