package firstTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Testing arcsin func")
public class MathTest {
    private Function func;

    @BeforeEach
    void setup(){
        this.func = new Function();
    }

    @ParameterizedTest(name = "Calculate arcsin({0})")
    @CsvFileSource(resources = "/firstTask/arcsin_test.csv")
    void arcsinTest(double expected, double input) throws InfinityValueException {
        final double actual = func.arcsin(input);
        final double accuracy = 1e-1;
        System.out.printf("expected = %9f | inputDegrees = %2f | actual = %9f\n",
                expected, input, actual);
        assertEquals(expected, actual, accuracy);
    }

    @ParameterizedTest(name = "Exception arcsin({0})")
    @ValueSource(doubles = {55555.55, 234234.0129, -1242343.12})
    void arcsinExceptionTest(double value) {
        assertThrows(InfinityValueException.class, () -> {
            func.arcsin(value);
        });
    }

}
