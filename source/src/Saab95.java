import java.awt.*;

/**
 * The Saab95 class describes a car of the type Saab95.
 */

public class Saab95 extends Car{

    /**
     * Turbo on/off
     */
    private boolean turboOn;

    /**
     * Constructor for class Saab95.
     */
    public Saab95(){
        super(2,125, Color.red,"Saab95");
        turboOn = false;
    }

    /**
     * Changes boolean turboOn to true.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Changes boolean turboOn to false.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    // Following methods need to be implemented according to superclass

    /**
     * Calculates speedFactor based on EnginePower and turbo.
     * @return speedFactor of car
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * Increment CurrentSpeed based on speedFactor and amount.
     * @param amount a factor defining the intensity of increase in speed
     */
    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    /**
     * Decrement CurrentSpeed based on speedFactor and amount.
     * @param amount a factor defining the intensity of decrease in speed
     */
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    /**
     * Calls specific car-models method incrementSpeed().
     * @param amount a factor defining the intensity of increase in speed
     */
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    /**
     * Calls specific car-models method decrementSpeed().
     * @param amount a factor defining the intensity of decrease in speed
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}