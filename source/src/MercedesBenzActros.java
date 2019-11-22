import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * The MercedesBenzActros class describes a car-transporter of the type Mercedes-Benz Actros.
 */
public class MercedesBenzActros extends Car implements ITransporter<Car>{

    /**
     * Variable for if the Actros has a trailer connected.
     */
    private boolean hasCarTrailerConnected = true;
    /**
     * Car-trailer connected from the beginning.
     */
    private CarTrailer carTrailer = new CarTrailer(10);
    /**
     * List with cars on the car-transporter.
     */
    private List<Car> cars = new ArrayList<>();

    /**
     * Constructor for Mercedes-Benz Actros
     */
    MercedesBenzActros() {
        super(2, 150, Color.magenta, "Mercedes-Benz Actros");
    }

    /**
     * Method from IMovable, overridden from Car, which updates the position of cars stored on the car-transporter
     * while it's moving.
     */
    @Override
    public void move() {
        super.move();
        for (Car c : cars) {
            c.setPosX(getPosX());
            c.setPosY(getPosY());
        }
    }

    /**
     * Method which calculates the speed factor of the Actros based on if it has a trailer connected.
     * @return new speed factor
     */
    @Override
    public double speedFactor() {
        if (hasCarTrailerConnected) {
            return getEnginePower() * 0.01 * 0.5;
        }
        return getEnginePower() * 0.01;
    }

    /**
     * Method which decrements the speed of the Actros.
     * @param amount a factor defining the intensity of decrease in speed
     */
    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    /**
     * Method which increments the speed of the Actros.
     * @param amount a factor defining the intensity of increase in speed
     */
    @Override
    public void incrementSpeed(double amount) {
        if (carTrailer != null && !carTrailer.isDown()) {
            setCurrentSpeed(getCurrentSpeed());
        } else {
            setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
        }
    }

    /**
     * Adds a trailer to the Actros. Not part of the exercise and should not be used, but fun thing none the less.
     * @param maxSize maximum amount of cars able to be stored in the trailer
     */
    public void addTrailer(int maxSize) {
        carTrailer = new CarTrailer(maxSize);
        hasCarTrailerConnected = true;
    }

    /**
     * Removes a trailer from the Actros. Not part of the exercise and should not be used, but fun thing none the less.
     */
    public void removeTrailer() {
        carTrailer = null;
        hasCarTrailerConnected = false;
    }

    /**
     * Method from ITransporter which loads the car trailer with a car if it's close enough to the car trailer.
     * @param car the car which should be loaded
     */
    public void load(Car car) {
        if (car.getTransportable() && !car.isBeingTransported()) {
            double xDifference = car.getPosX() - getPosX();
            double yDifference = car.getPosY() - getPosY();
            if (xDifference < 10 && yDifference < 10) {
                if (this != car && getCurrentSpeed() == 0) {
                    carTrailer.load(car);
                    car.startTransporting();
                }
            }
        }
    }

    /**
     * Method from ITransporter which unloads the latest stored car if the Actros stands still.
     * @return the unloaded car, returns null if the Actros is moving.
     */
    @Override
    public Car unload() {
        Car car;
        if (getCurrentSpeed() == 0) {
            car = carTrailer.unload();
            car.stopTransporting();
            return car;
        }
        return null;
    }






}
