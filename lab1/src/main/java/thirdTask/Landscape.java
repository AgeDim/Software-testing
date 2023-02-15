package thirdTask;

public class Landscape {
    private Ground ground;
    private boolean vegetation;
    private float dustThickness;

    public Landscape(Ground ground, boolean vegetation, float dustThickness) {
        this.ground = ground;
        this.vegetation = vegetation;
        this.dustThickness = dustThickness;
    }

    // Getters and setters for ground, vegetation, and dustThickness properties
    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public boolean hasVegetation() {
        return vegetation;
    }

    public void setVegetation(boolean vegetation) {
        this.vegetation = vegetation;
    }

    public float getDustThickness() {
        return dustThickness;
    }

    public void setDustThickness(float dustThickness) {
        this.dustThickness = dustThickness;
    }
}
