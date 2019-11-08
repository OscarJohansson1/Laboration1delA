import java.awt.*;
import java.lang.Math;

/**
 * The Car class describes shared elements between the different car-models. No object of Car should be able to be
 * created and the class is therefore abstract and serves as a template.
 */

public abstract class Car implements IMovable{

    // Instance variables used by the different car models
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name'
    private double posX;
    private double posY;
    private int angle;

    /**
     * Constructor for shared variables from car-models.
     * @param nrDoors number of doors in the car
     * @param enginePower power of the car-engine
     * @param color color of the car
     * @param modelName model-name of the car
     */
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

    /**
     * Starts car-engine and gives car slight speed forward.
     */
    public void startEngine(){ currentSpeed = 0.1; }

    /**
     * Stops car-engine and sets speed to zero.
     */
    private void stopEngine(){ currentSpeed = 0; }

    // Abstract methods that should be implemented in every class extending Car
    public abstract double speedFactor();
    public abstract void decrementSpeed(double amount);
    public abstract void incrementSpeed(double amount);

    /**
     * Implementation of interface IMovable method move.
     */
    @Override
    public void move() {
        posX *= Math.cos(Math.toRadians(angle))*currentSpeed;
        posY *= Math.sin(Math.toRadians(angle))*currentSpeed;
    }

    /**
     * Implementation of interface IMovable method turnLeft.
     */
    @Override
    public void turnLeft() {
        angle = (angle - 90) % 360;
    }

    /**
     * Implementation of interface IMovable method turnRight.
     */
    @Override
    public void turnRight() {
        angle = (angle + 90) % 360;
    }
}
