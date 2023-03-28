
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogarithmicIntegrationTest {

    MathOfLab math = new MathOfLab();

    @ParameterizedTest
    @MethodSource("logarithmProvider")
    void testLogarithm(int base, double value, double expected) {
        assertEquals(expected, math.log(base, value), BasicTest.ALLOWED_PRECISION);
    }

    static Stream<Arguments> logarithmProvider() {
        return Stream.of(
                Arguments.of(3, 81, 4),
                Arguments.of(2, 64, 6),
                Arguments.of(3, -4, Double.NaN),
                Arguments.of(3, 0, Double.NaN),
                Arguments.of(0, 4, Double.NaN),
                Arguments.of(2, 0.125, -3),
                Arguments.of(64, 8, 0.5),
                Arguments.of(-1, -12, Double.NaN)
        );
    }
}