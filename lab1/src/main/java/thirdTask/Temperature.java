package thirdTask;

public class Temperature {
    private float degrees;
    private State state = State.None;

    public Temperature(float degrees) {
        this.degrees = degrees;
    }

    // Getter and setter for degrees property
    public float getDegrees() {
        return degrees;
    }

    public void setDegrees(float degrees) {
        this.degrees = degrees;
    }
    void updateState(){
        if(degrees >= 25f){
            state = State.Hot;
        } else if (degrees <= -5f) {
            state = State.Cold;
        }else{
            state = State.MEDIUM;
        }
    }

    public State getState() {
        return state;
    }

}
