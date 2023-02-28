package thirdTask;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FigureTest {
    Figure figure = new Figure(Movement.STAY);

    @Test
    void figureMovementTest() {
        figure.wander();
        assertThat(figure.getMovement()).isEqualTo(Movement.WANDER);
        assertThat(figure.getMovement()).isNotEqualTo(Movement.STAY);
    }
}