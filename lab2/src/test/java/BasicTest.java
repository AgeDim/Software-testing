
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicTest {

    public static final double ALLOWED_PRECISION = 0.001;

    @ParameterizedTest
    @MethodSource("sinArgsProvider")
    void testSinPositiveArgs(double x, double expected) {
        assertEquals(expected, Basic.sin(x), ALLOWED_PRECISION);
    }

    @ParameterizedTest
    @MethodSource("sinArgsProvider")
    void testSinNegativeArgs(double x, double expected) {
        assertEquals(-expected, Basic.sin(-x), ALLOWED_PRECISION);
    }

    static Stream<Arguments> sinArgsProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(PI, 0),
                Arguments.of(PI/2, 1),
                Arguments.of(PI/3, sqrt(3)/2),
                Arguments.of(PI/4, sqrt(2)/2),
                Arguments.of(PI/6, 0.5),
                Arguments.of(2*PI/3, sqrt(3)/2),
                Arguments.of(3*PI/4, sqrt(2)/2),
                Arguments.of(5*PI/6, 0.5),
                Arguments.of(2*PI, 0),
                Arguments.of(3*PI, 0),
                Arguments.of(3*PI/2, -1),
                Arguments.of(16*PI/3, -sqrt(3)/2)
        );
    }

    @ParameterizedTest
    @MethodSource("logArgsProvider")
    void testLogarithm(double x, double expected) {
        assertEquals(expected, Basic.ln(x), ALLOWED_PRECISION);
    }

    static Stream<Arguments> logArgsProvider() {
        return Stream.of(
                Arguments.of(exp(3), 3),
                Arguments.of(exp(5), 5),
                Arguments.of(exp(8), 8),
                Arguments.of(1, 0),
                Arguments.of(exp(10), 10),
                Arguments.of(exp(0.1), 0.1),
                Arguments.of(0, Double.NaN),
                Arguments.of(-5, Double.NaN),
                Arguments.of(-1, Double.NaN),
                Arguments.of(-0.5, Double.NaN)
        );
    }

    @Test
    void testSinSpecialValues() {
        MathOfLab math = new MathOfLab();
        assertEquals(Double.NaN, math.sin(Double.NaN));
        assertEquals(Double.NaN, math.sin(Double.NEGATIVE_INFINITY));
        assertEquals(Double.NaN, math.sin(Double.POSITIVE_INFINITY));
    }

}