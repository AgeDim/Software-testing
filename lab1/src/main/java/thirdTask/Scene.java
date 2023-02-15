package thirdTask;

public class Scene {
    private Landscape landscape;
    private Temperature temperature;
    private Figure[] figures;

    public Scene(Landscape landscape, Temperature temperature, Figure[] figures) {
        this.landscape = landscape;
        this.temperature = temperature;
        this.figures = figures;
    }

    // Getters and setters for landscape, temperature, and figures properties
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

    public Figure[] getFigures() {
        return figures;
    }

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }
}