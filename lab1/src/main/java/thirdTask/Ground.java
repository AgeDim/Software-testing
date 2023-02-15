package thirdTask;

public class Ground {
    private Color color;
    private String texture;

    public Ground(Color color, String texture) {
        this.color = color;
        this.texture = texture;
    }

    // Getters and setters for color and texture properties
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
}
