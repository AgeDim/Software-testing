package thirdTask;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class SceneTest {
    Ground ground;
    Landscape landscape;
    Figure figure0 = new Figure(Movement.WANDER);
    Figure figure1 = new Figure(Movement.STAY);
    Figure figure2 = new Figure(Movement.WALK);
    Figure figure3 = new Figure(Movement.RUNNING);
    Figure figure4 = new Figure(Movement.STAY);
    ArrayList<Figure> figures = new ArrayList<>();
    Temperature temperature;
    Scene scene = new Scene();

    @Test
    void figureTest(){
        figures.add(figure0);
        figures.add(figure1);
        figures.add(figure2);
        figures.add(figure3);
        figures.add(figure4);
        scene = new Scene(landscape, temperature, figures);
        ArrayList<Figure> test = scene.getFigures();
        assertThat(test.size()).isEqualTo(5);
        ArrayList<Figure> test1 = new ArrayList<>();
        test1.add(new Figure(Movement.WANDER));
        test1.add(new Figure(Movement.STAY));
        scene.setFigures(test1);
        test = scene.getFigures();
        assertThat(test.size()).isEqualTo(2);
    }

    @Test
    void landScapeTest(){
        scene = new Scene(new Landscape(new Ground(Color.WHITE, "Болото"), true, 250), new Temperature(25), figures);
        Landscape land = scene.getLandscape();
        assertThat(land.getDustThickness()).isEqualTo(250);
        assertThat(land.hasVegetation()).isTrue();
        assertThat(land.getGround().getColor()).isEqualTo(Color.WHITE);
        assertThat(land.getGround().getTexture()).isEqualTo("Болото");
        assertThat(scene.getTemperature().getDegrees()).isEqualTo(25);
        Ground groundTest = new Ground(Color.GRAY, "Равнина");
        Landscape landscape = new Landscape(groundTest, false, 1);
        Temperature temp = new Temperature(-10);
        scene.setTemperature(temp);
        scene.setLandscape(landscape);
        assertThat(scene.getTemperature().getDegrees()).isEqualTo(-10);
        land = scene.getLandscape();
        assertThat(land.hasVegetation()).isFalse();
        assertThat(land.getDustThickness()).isEqualTo(1);
        assertThat(land.getGround().getTexture()).isEqualTo("Равнина");
    }

    @Test
    void sceneTest() {
        figures.add(figure0);
        figures.add(figure1);
        figures.add(figure2);
        figures.add(figure3);
        figures.add(figure4);
        ground = new Ground(Color.BROWN, "Болото");
        landscape = new Landscape(ground,false, 90);
        temperature = new Temperature(-50);
        temperature.updateState();
        scene.setLandscape(landscape);
        scene.setFigures(figures);
        scene.setTemperature(temperature);
        assertThat(scene.getTemperature().getDegrees()).isEqualTo(-50);
        assertThat(scene.getTemperature().getState()).isEqualTo(State.Cold);
        assertThat(scene.getFigures().size()).isEqualTo(5);
        assertThat(scene.getLandscape().getDustThickness()).isEqualTo(90);
        assertThat(scene.getLandscape().hasVegetation()).isFalse() ;
    }
}
