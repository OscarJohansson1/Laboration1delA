import java.awt.*;

public abstract class Car {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    double getEnginePower(){
        return enginePower;
    }
    double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }
    void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    void stopEngine(){
        currentSpeed = 0;
    }
    //abstract metod i abstract klass agerar som interface på så sätt
    //att alla som ärver måste innehålla metoden
    public abstract double speedFactor();
    public abstract void decrementSpeed(double amount);
    public abstract void incrementSpeed(double amount);
}
