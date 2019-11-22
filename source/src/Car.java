import java.awt.*;
import java.lang.Math;

/**
 * The Car class describes shared elements between the different car-models. No object of Car should be able to be
 * created and the class is therefore abstract and serves as a template.
 */

public abstract class Car implements IMovable{

    /**
     * Number of doors on the car
      */
    private final int nrDoors;
    /**
     * Engine power of the car
     */
    private final double enginePower;
    /**
     * The current speed of the car
     */
    private double currentSpeed;
    /**
     * Color of the car
     */
    private Color color;
    /**
     * The car model name
     */
    private final String modelName;
    /**
     * Cars x-position
     */
    private double posX;
    /**
     * Cars y-position
     */
    private double posY;
    /**
     * Cars current direction
     */
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

    /**
     * Get number of doors on car.
     * @return number of doors
     */
    int getNrDoors(){ return nrDoors; }

    /**
     * Get engine power of car.
     * @return engine power
     */
    double getEnginePower(){ return enginePower; }

    /**
     * Get current speed of car.
     * @return current speed
     */
    double getCurrentSpeed(){ return currentSpeed; }

    /**
     * Get color of car.
     * @return color
     */
    Color getColor(){ return color; }

    /**
     * Get model name of car.
     * @return model name
     */
    String getModelName(){ return modelName; }

    /**
     * Get x-position of car.
     * @return x-position
     */
    double getPosX(){ return posX; }

    /**
     * Get y-position of car.
     * @return y-position
     */
    double getPosY(){ return posY; }

    /**
     * Get angle car is currently facing.
     * @return angle
     */
    int getAngle(){ return angle; }

    /**
     * Set x-position of car.
     * @param x new x-position
     */
    void setPosX(double x) { posX = x; }

    /**
     * Set y-position of car.
     * @param y new y-position
     */
    void setPosY(double y) { posY = y; }

    /**
     * Set color of car.
     * @param clr new color
     */
    void setColor(Color clr){ color = clr; }

    /**
     * Set current speed of car.
     * @param currentSpeed new current speed.
     */
    void setCurrentSpeed(double currentSpeed){ this.currentSpeed = currentSpeed; }

    // Shared methods between different car models, that are equal to all models.

    /**
     * Starts car-engine and gives car slight speed forward.
     */
    void startEngine(){ currentSpeed = 0.1; }

    /**
     * Stops car-engine and sets speed to zero.
     */
    void stopEngine(){ currentSpeed = 0; }

    // Abstract methods that should be implemented in every class extending Car

    /**
     * Calculates speedFactor for car based on EnginePower and specifics
     * for the different car-models. Should be implemented in subclasses.
     * @return speedFactor of car
     */
    public abstract double speedFactor();

    /**
     * Decrement CurrentSpeed based on speedFactor and amount. Should be
     * implemented in subclasses.
     * @param amount a factor defining the intensity of decrease in speed
     */
    public abstract void decrementSpeed(double amount);

    /**
     * Increment CurrentSpeed based on speedFactor and amount. Should be
     * implemented in subclasses.
     * @param amount a factor defining the intensity of increase in speed
     */
    public abstract void incrementSpeed(double amount);

    /**
     * Implementation of interface IMovable method move.
     */
    @Override
    public void move() {
        posX += Math.cos(Math.toRadians(angle))*currentSpeed;
        posY += Math.sin(Math.toRadians(angle))*currentSpeed;
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

    /**
     * Calls specific car-models method incrementSpeed().
     * @param amount a factor defining the intensity of increase in speed
     */
    void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
            if (getCurrentSpeed() > getEnginePower()) {
                setCurrentSpeed(getEnginePower());
            }
        }
    }

    /**
     * Calls specific car-models method decrementSpeed().
     * @param amount a factor defining the intensity of decrease in speed
     */
    void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
            if (getCurrentSpeed() < 0) {
                setCurrentSpeed(0);
            }
        }
    }
}
