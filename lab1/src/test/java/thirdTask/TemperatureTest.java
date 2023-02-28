package thirdTask;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TemperatureTest {
    Temperature temperature;
    @Test
    void temperatureTest(){
        temperature = new Temperature(-10);
        temperature.updateState();
        assertThat(temperature.getState()).isEqualTo(State.Cold);
        assertThat(temperature.getDegrees()).isEqualTo(-10);
        temperature.setDegrees(20);
        temperature.updateState();
        assertThat(temperature.getDegrees()).isEqualTo(20);
        assertThat(temperature.getState()).isEqualTo(State.MEDIUM);
        temperature.setDegrees(50);
        temperature.updateState();
        assertThat(temperature.getDegrees()).isEqualTo(50);
        assertThat(temperature.getState()).isEqualTo(State.Hot);
    }
}
