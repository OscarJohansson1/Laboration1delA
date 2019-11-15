import java.awt.*;

public class Scania extends Car {

    private Trailer trailer;
    private boolean hasTrailerConnected = false;

    /**
     * Constructor for shared variables from car-models.
     */
    Scania() {
        super(2, 150, Color.blue, "Scania");
    }

    public void addTrailer() {
        trailer = new Trailer(70);
        hasTrailerConnected = true;
    }

    public void removeTrailer() {
        trailer = null;
        hasTrailerConnected = false;
    }
    
    @Override
    public double speedFactor() {
        if (hasTrailerConnected) {
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
        if (trailer != null && !trailer.isDown()) {
            setCurrentSpeed(getCurrentSpeed());
        } else {
            setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
        }
    }
}
