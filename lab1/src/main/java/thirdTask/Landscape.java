package thirdTask;

public class Landscape {
    private Ground ground;
    private boolean vegetation;
    private float dustThickness;

    public Landscape() {
    }

    public Landscape(Ground ground, boolean vegetation, float dustThickness) {
        this.ground = ground;
        this.vegetation = vegetation;
        this.dustThickness = dustThickness;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public Ground getGround() {
        return ground;
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
