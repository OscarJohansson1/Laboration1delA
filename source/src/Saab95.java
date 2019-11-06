import java.awt.*;

/**
 * The Saab95 class describes a car of the type Saab95.
 */

public class Saab95 extends Car{
    // Instance variables specific to Saab95 (others in Car)
    private boolean turboOn;

    // Constructor
    public Saab95(){
        super(2,125, Color.red,"Saab95");
        turboOn = false;
    }

    // Methods specific to Saab95
    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;
    }

    // Following methods need to be implemented according to superclass
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
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