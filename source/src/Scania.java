import java.awt.*;

public class Scania extends Car {

    //Flak object
    private boolean hasLoadingPlatformConnected = false;

    /**
     * Constructor for shared variables from car-models.
     */
    Scania() {
        super(2, 150, Color.blue, "Scania");
    }

    public void addLoadingPlatform() {
        //...
    }
    
    @Override
    public double speedFactor() {
        if (hasLoadingPlatformConnected) {
          return getEnginePower() * 0.01 * 0.5;
        }
        return getEnginePower() * 0.01;
    }

    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    @Override
    public void incrementSpeed(double amount) {
        //if (flakDown) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
        //}
        //
    }
}
