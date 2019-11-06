import java.awt.*;

/**
 * The Volvo240 class describes a car of the type Volvo240.
 */

public class Volvo240 extends Car{
    // Instance variables specific to Volvo240 (others in Car)
    private final static double trimFactor = 1.25;

    //Constructor
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }

    // Following methods need to be implemented according to superclass
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }


    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}