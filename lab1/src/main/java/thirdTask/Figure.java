package thirdTask;

public class Figure {
    private int number;
    private Movement movement;

    public Figure(int number, Movement movement) {
        this.number = number;
        this.movement = movement;
    }

    // Getters and setters for number and movement properties
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
}