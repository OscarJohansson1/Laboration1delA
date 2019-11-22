import java.awt.*;
/**
 * The Scania class describes a truck of the type Scania.
 */
public class Scania extends Car {

    private Trailer trailer;
    private boolean hasTrailerConnected = false;

    /**
     * Constructor for shared variables from car-models.
     */
    Scania() {
        super(2, 150, Color.blue, "Scania");
    }

    /**
     * Add a trailer to Scania.
     */
    public void addTrailer() {
        trailer = new Trailer(70);
        hasTrailerConnected = true;
    }

    /**
     * Remove a trailer from Scania.
     */
    public void removeTrailer() {
        trailer = null;
        hasTrailerConnected = false;
    }

    /**
     * Get angle of trailer.
     * @return Trailer angle
     */
    public int getCurrentAngleOfTrailer() {
        return trailer.getAngle();
    }

    /**
     * Raises the angle of the trailer by an amount of degrees.
     */
    public void raiseTrailer(int amount) {
        trailer.raise(amount);
    }

    /**
     * Lowers the angle of the trailer by an amount of degrees.
     */
    public void lowerTrailer(int amount) {
        trailer.lower(amount);
    }

    /**
     * Get boolean value of whether a trailers is connected to Scania or not.
     * @return If a trailer is connected: true, else: false
     */
    public boolean getTrailerConnected(){return hasTrailerConnected;}

    /**
     * Calculates speedFactor based on EnginePower. Slower acceleration while a trailer is connected.
     * @return speedFactor of car
     */
    @Override
    public double speedFactor() {
        if (hasTrailerConnected) {
          return getEnginePower() * 0.01 * 0.5;
        }
        return getEnginePower() * 0.01;
    }


    /**
     * Decrement CurrentSpeed based on speedFactor and amount.
     * @param amount a factor defining the intensity of decrease in speed
     */
    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    /**
     * Increment CurrentSpeed based on speedFactor and amount.
     * @param amount a factor defining the intensity of decrease in speed
     */
    @Override
    public void incrementSpeed(double amount) {
        if (trailer != null && !trailer.isDown()) {
            setCurrentSpeed(getCurrentSpeed());
        } else {
            setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
        }
    }
}
