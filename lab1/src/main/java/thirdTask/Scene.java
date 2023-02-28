package thirdTask;

import java.util.ArrayList;

public class Scene {
    private Landscape landscape;
    private Temperature temperature;
    private ArrayList<Figure> figures;

    public Scene(){}
    public Scene(Landscape landscape, Temperature temperature, ArrayList<Figure> figures) {
        this.landscape = landscape;
        this.temperature = temperature;
        this.figures = figures;
    }

    public Landscape getLandscape() {
        return landscape;
    }

    public void setLandscape(Landscape landscape) {
        this.landscape = landscape;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public void setFigures(ArrayList<Figure> figures) {
        this.figures = figures;
    }
}