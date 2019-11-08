import java.awt.*;

/**
 * The Volvo240 class describes a car of the type Volvo240.
 */

public class Volvo240 extends Car {

    // Instance variables specific to Volvo240 (others in Car)
    private final static double trimFactor = 1.25;

    /**
     * Constructor for class Volvo240.
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }

    // Following methods need to be implemented according to superclass
    /**
     * Calculates speedFactor based on EnginePower and trimFactor.
     * @return speedFactor of car
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Increment CurrentSpeed based on speedFactor and amount. Also ensures
     * speed does not exceed EnginePower.
     * @param amount a factor defining the intensity of increase in speed
     */
    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    /**
     * Increment CurrentSpeed based on speedFactor and amount. Also ensures
     * speed does not deceed 0. (Deceed: opposite of exceed)
     * @param amount a factor defining the intensity of increase in speed
     */
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
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