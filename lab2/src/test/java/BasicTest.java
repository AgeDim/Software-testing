
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
    @MethodSource("cosArgsProvider")
    void testSinPositiveArgs(double x, double expected) {
        assertEquals(expected, Basic.cos(x), ALLOWED_PRECISION);
    }

    @ParameterizedTest
    @MethodSource("cosArgsProvider")
    void testSinNegativeArgs(double x, double expected) {
        assertEquals(expected, Basic.cos(-x), ALLOWED_PRECISION);
    }

    static Stream<Arguments> cosArgsProvider() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(PI, -1),
                Arguments.of(PI/2, 0),
                Arguments.of(PI/3, 0.5),
                Arguments.of(PI/4, sqrt(2)/2),
                Arguments.of(PI/6, sqrt(3)/2),
                Arguments.of(2*PI/3, -0.5),
                Arguments.of(3*PI/4, -sqrt(2)/2),
                Arguments.of(5*PI/6, -sqrt(3)/2),
                Arguments.of(2*PI, 1),
                Arguments.of(3*PI, -1),
                Arguments.of(3*PI/2, 0),
                Arguments.of(16*PI/3, -0.5));
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
    void testCosSpecialValues() {
        MathOfLab math = new MathOfLab();
        assertEquals(Double.NaN, math.cos(Double.NaN));
        assertEquals(Double.NaN, math.cos(Double.NEGATIVE_INFINITY));
        assertEquals(Double.NaN, math.cos(Double.POSITIVE_INFINITY));
    }

}