import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicIntegrationTest {

    SystemMath system = new SystemMath(new MathOfLab());

    @ParameterizedTest
    @MethodSource("provideCosData")
    void testFunctionDependingOnCosinus(double x, double cosX, double cosHalf, double expected) {
        try (MockedStatic<Basic> utils = Mockito.mockStatic(Basic.class)) {
            utils.when(() -> Basic.cos(x)).thenReturn(cosX);
            utils.when(() -> Basic.cos(x/2)).thenReturn(cosHalf);
            assertEquals(expected, system.calculateFunction(x), BasicTest.ALLOWED_PRECISION);
        }
    }

    static Stream<Arguments> provideCosData() {
        return Stream.of(
                Arguments.of(-0.5, sqrt(3)/2, 0.965926, 5.260626214860996),
                Arguments.of(-23, 0.84622, 0.87545, 12.1045),
                Arguments.of(-Math.PI/4, -0.7071, 0.3827, -7.7763)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLogData")
    void testFunctionDependingOnLog(double x, double log, double expected) {
        try (MockedStatic<Basic> utils = Mockito.mockStatic(Basic.class)) {
            utils.when(() -> Basic.ln(x)).thenReturn(log);
            utils.when(() -> Basic.ln(5)).thenReturn(1.6094);
            utils.when(() -> Basic.ln(3)).thenReturn(1.0986);
            utils.when(() -> Basic.ln(10)).thenReturn(2.3026);
            utils.when(() -> Basic.ln(2)).thenReturn(0.6931);

            assertEquals(expected, system.calculateFunction(x), BasicTest.ALLOWED_PRECISION);
        }
    }

    static Stream<Arguments> provideLogData() {
        return Stream.of(
                Arguments.of(0.5, -0.693, -3.478529378620244E-5),
                Arguments.of(1.7, 0.5306, 2.1713457252143182E-7),
                Arguments.of(5, 1.6094, 8419.78100069055)
        );
    }

}