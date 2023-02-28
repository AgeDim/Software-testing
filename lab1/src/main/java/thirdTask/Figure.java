package thirdTask;

public class Figure {
    private Movement movement;

    public Figure(Movement movement) {
        this.movement = movement;
    }

    // Getters and setters for number and movement properties
    public Movement getMovement() {
        return movement;
    }

    public void wander(){
        this.movement = Movement.WANDER;
    }
}