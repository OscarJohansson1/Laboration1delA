import java.awt.*;

/**
 * The Car class describes shared elements between the different car-models. No object of Car should be able to be
 * created and the class is therefore abstract and serves as a template.
 */

public abstract class Car {

    // Hej igen!!!

    // Instance variables used by the different car models
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    //Constructor
    Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    // Getters and Setters

    public int getNrDoors(){ return nrDoors; }

    double getEnginePower(){ return enginePower; }

    double getCurrentSpeed(){ return currentSpeed; }

    public Color getColor(){ return color; }

    public void setColor(Color clr){ color = clr; }

    void setCurrentSpeed(double currentSpeed){ this.currentSpeed = currentSpeed; }

    // Shared methods between different car models, that are equal to all models.
    public void startEngine(){ currentSpeed = 0.1; }

    private void stopEngine(){ currentSpeed = 0; }

    // Abstract methods that should be implemented in every class extending Car
    public abstract double speedFactor();
    public abstract void decrementSpeed(double amount);
    public abstract void incrementSpeed(double amount);
}
