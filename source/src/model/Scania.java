package model;

import java.awt.*;
/**
 * The model.Scania class describes a truck of the type model.Scania.
 */
public class Scania extends Car {

    private Trailer trailer;
    private boolean hasTrailerConnected = false;

    /**
     * Constructor for shared variables from car-models.
     */
    Scania() {
        super(2, 150, Color.blue, "model.Scania");
        addTrailer();
    }

    /**
     * Add a trailer to model.Scania.
     */
    public void addTrailer() {
        trailer = new Trailer(70);
        hasTrailerConnected = true;
    }

    /**
     * Remove a trailer from model.Scania.
     */
    public void removeTrailer() {
        trailer = null;
        hasTrailerConnected = false;
    }

    /**
     * Get angle of trailer.
     * @return model.Trailer angle
     */
    public int getCurrentAngleOfTrailer() {
        return trailer.getAngle();
    }

    /**
     * Raises the angle of the trailer by an amount of degrees.
     * @param amount amount of degrees to raise the trailer
     */
    public void raiseTrailer(int amount) {
        if (getCurrentSpeed() <= 0) {
            trailer.raise(amount);
        }
    }

    /**
     * Lowers the angle of the trailer by an amount of degrees.
     * @param amount amount of degrees to lower the trailer
     */
    public void lowerTrailer(int amount) {
        if (getCurrentSpeed() <= 0) {
            trailer.lower(amount);
        }
    }

    @Override
    public void move() {
        if(hasTrailerConnected) {
            if (trailer.isDown()) {
                super.move();
            }
        }
        else{
            super.move();
            }
    }

    public boolean hasTrailer(){
        return hasTrailerConnected;
    }

    /**
     * Get boolean value of whether a trailers is connected to model.Scania or not.
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
