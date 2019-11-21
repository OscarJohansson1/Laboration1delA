/**
 * The CarTrailer class describes a trailer which store cars.
 */
public class CarTrailer implements IRaiseable, ITransporter<Car> {
    /**
     * Variable for if trailer is down or not'
     */
    private boolean trailerIsDown = true;
    /**
     * Variable for the storage where the car trailer stores it's cars.
     */
    private Storage<Car> storage;

    /**
     * Constructor for car trailer.
     * @param maxStorage maximum amount of objects that can be stored
     */
    public CarTrailer(int maxStorage) {
        this.storage = new Storage<>(maxStorage);
    }

    /**
     * Get amount of cars stored in the car trailer.
     * @return number of cars in storage
     */
    public int getAmountOfCars() {
        return storage.size();
    }

    /**
     * Method from IRaiseable which answers if the car trailer is down.
     * @return true if trailer is down
     */
    @Override
    public boolean isDown() {
        return trailerIsDown;
    }

    /**
     * Method from IRaiseable which answers if the car trailer is fully raised.
     * @return true if trailer isn't down
     */
    @Override
    public boolean isFullyRaised() {
        return !trailerIsDown;
    }

    /**
     * Method from IRaiseable which raise the trailer.
     */
    @Override
    public void raise() {
        trailerIsDown = false;
    }

    /**
     * Method from IRaiseable which lower the trailer
     */
    @Override
    public void lower() {
        trailerIsDown = true;
    }

    /**
     * Method from ITransporter which loads storage with car.
     * @param car defines what car to store in storage
     */
    @Override
    public void load(Car car) {
        storage.load(car);
    }

    /**
     * Method from ITransporter which unloads the latest car stored in the storage
     * @return latest stored car
     */
    @Override
    public Car unload() {
        return storage.removeLastStored();
    }
}
