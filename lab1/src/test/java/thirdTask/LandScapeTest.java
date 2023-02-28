package thirdTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LandScapeTest {
    Ground ground;
    Landscape landscape = new Landscape();
    @BeforeEach
            void setUp(){
        ground = new Ground(Color.GRAY, "Пустыня");
        landscape.setGround(ground);
        landscape.setVegetation(false);
        landscape.setDustThickness(100);
    }


    @Test
    void landscapeGroundTest() {
        Ground groundTest = landscape.getGround();
        assertThat(groundTest.getColor()).isEqualTo(Color.GRAY);
        assertThat(groundTest.getTexture()).isEqualTo("Пустыня");
        groundTest.setColor(Color.BROWN);
        groundTest.setTexture("Болото");
        assertThat(groundTest.getColor()).isEqualTo(Color.BROWN);
        assertThat(groundTest.getTexture()).isEqualTo("Болото");
    }
    @Test
    void landscapeTest(){
        assertThat(landscape.hasVegetation()).isFalse();
        assertThat(landscape.getDustThickness()).isEqualTo(100);
        landscape.setVegetation(true);
        landscape.setDustThickness(0.5F);
        assertThat(landscape.hasVegetation()).isTrue();
        assertThat(landscape.getDustThickness()).isEqualTo(0.5F);
    }

}
