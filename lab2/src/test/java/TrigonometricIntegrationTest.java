
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometricIntegrationTest {

    MathOfLab math = new MathOfLab();

    @Nested
    class Cosine {
        @ParameterizedTest
        @MethodSource("cosArgsProvider")
        void testCosPositiveArgs(double x, double expected) {
            assertEquals(expected, math.cos(x), BasicTest.ALLOWED_PRECISION);
        }

        @ParameterizedTest
        @MethodSource("cosArgsProvider")
        void testCosNegativeArgs(double x, double expected) {
            assertEquals(expected, math.cos(-x), BasicTest.ALLOWED_PRECISION);
        }

        static Stream<Arguments> cosArgsProvider() {
            return Stream.of(
                    Arguments.of(0, 1),
                    Arguments.of(PI, -1),
                    Arguments.of(PI / 2, 0),
                    Arguments.of(PI / 3, 0.5),
                    Arguments.of(PI / 4, sqrt(2) / 2),
                    Arguments.of(PI / 6, sqrt(3) / 2),
                    Arguments.of(2 * PI / 3, -0.5),
                    Arguments.of(3 * PI / 4, -sqrt(2) / 2),
                    Arguments.of(5 * PI / 6, -sqrt(3) / 2),
                    Arguments.of(2 * PI, 1),
                    Arguments.of(3 * PI, -1),
                    Arguments.of(3 * PI / 2, 0),
                    Arguments.of(16 * PI / 3, -0.5)
            );
        }
    }

    @Nested
    class Tangent {
        @ParameterizedTest
        @MethodSource("tanArgsProvider")
        void testTanPositiveArgs(double x, double expected) {
            assertEquals(expected, math.tan(x), BasicTest.ALLOWED_PRECISION);
        }

        @ParameterizedTest
        @MethodSource("tanArgsProvider")
        void testTanNegativeArgs(double x, double expected) {
            assertEquals(-expected, math.tan(-x), BasicTest.ALLOWED_PRECISION);
        }

        static Stream<Arguments> tanArgsProvider() {
            return Stream.of(
                    Arguments.of(0, 0),
                    Arguments.of(PI, 0),
                    Arguments.of(PI / 3, sqrt(3)),
                    Arguments.of(PI / 4, 1),
                    Arguments.of(PI / 6, 1 / sqrt(3)),
                    Arguments.of(2 * PI / 3, -sqrt(3)),
                    Arguments.of(3 * PI / 4, -1),
                    Arguments.of(5 * PI / 6, -1 / sqrt(3)),
                    Arguments.of(2 * PI, 0),
                    Arguments.of(3 * PI, 0),
                    Arguments.of(16 * PI / 3, sqrt(3))
            );
        }
    }

    @Nested
    class Cotangent {
        @ParameterizedTest
        @MethodSource("cotanArgsProvider")
        void testCotanPositiveArgs(double x, double expected) {
            assertEquals(expected, math.cotan(x), BasicTest.ALLOWED_PRECISION);
        }

        @ParameterizedTest
        @MethodSource("cotanArgsProvider")
        void testCotanNegativeArgs(double x, double expected) {
            assertEquals(-expected, math.cotan(-x), BasicTest.ALLOWED_PRECISION);
        }

        static Stream<Arguments> cotanArgsProvider() {
            return Stream.of(
                    Arguments.of(PI / 2, 0),
                    Arguments.of(PI / 3, 1 / sqrt(3)),
                    Arguments.of(PI / 4, 1),
                    Arguments.of(PI / 6, sqrt(3)),
                    Arguments.of(2 * PI / 3, -1 / sqrt(3)),
                    Arguments.of(3 * PI / 4, -1),
                    Arguments.of(5 * PI / 6, -sqrt(3))
            );
        }
    }

    @Nested
    class Secant {
        @ParameterizedTest
        @MethodSource("secantArgsProvider")
        void testSecantPositiveArgs(double x, double expected) {
            assertEquals(expected, math.sec(x), BasicTest.ALLOWED_PRECISION);
        }

        @ParameterizedTest
        @MethodSource("secantArgsProvider")
        void testSecantNegativeArgs(double x, double expected) {
            assertEquals(expected, math.sec(-x), BasicTest.ALLOWED_PRECISION);
        }

        static Stream<Arguments> secantArgsProvider() {
            return Stream.of(
                    Arguments.of(0, 1),
                    Arguments.of(PI / 3, 2),
                    Arguments.of(PI / 4, sqrt(2)),
                    Arguments.of(PI / 6, 2 * sqrt(3) / 3),
                    Arguments.of(2 * PI / 3, -2),
                    Arguments.of(3 * PI / 4, -sqrt(2)),
                    Arguments.of(5 * PI / 6, -2 * sqrt(3) / 3),
                    Arguments.of(2.8, -1.061)
            );
        }
    }

    @Nested
    class Cosecant {
        @ParameterizedTest
        @MethodSource("cosecantArgsProvider")
        void testCosecantPositiveArgs(double x, double expected) {
            assertEquals(expected, math.cosec(x), BasicTest.ALLOWED_PRECISION);
        }

        @ParameterizedTest
        @MethodSource("cosecantArgsProvider")
        void testCosecantNegativeArgs(double x, double expected) {
            assertEquals(-expected, math.cosec(-x), BasicTest.ALLOWED_PRECISION);
        }

        static Stream<Arguments> cosecantArgsProvider() {
            return Stream.of(
                    Arguments.of(PI / 2, 1),
                    Arguments.of(PI / 3, 2 * sqrt(3) / 3),
                    Arguments.of(PI / 4, sqrt(2)),
                    Arguments.of(PI / 6, 2),
                    Arguments.of(2 * PI / 3, 2 * sqrt(3) / 3),
                    Arguments.of(3 * PI / 4, sqrt(2)),
                    Arguments.of(5 * PI / 6, 2),
                    Arguments.of(2.8, 2.985)
            );
        }
    }
}