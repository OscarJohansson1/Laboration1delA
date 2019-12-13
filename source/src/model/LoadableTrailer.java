package model;

/**
 * The CarTrailer class describes a trailer which store cars.
 */
public class LoadableTrailer<T> implements IRaiseable, ITransporter<T> {
    /**
     * Variable for if trailer is down or not'
     */
    private boolean trailerIsDown = true;
    /**
     * Variable for the storage where the car trailer stores it's cars.
     */
    private Storage<T> storage;

    /**
     * Constructor for car trailer.
     * @param maxStorage maximum amount of objects that can be stored
     */
    public LoadableTrailer(int maxStorage) {
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
     * Method from model.IRaiseable which answers if the car trailer is down.
     * @return true if trailer is down
     */
    @Override
    public boolean isDown() {
        return trailerIsDown;
    }

    /**
     * Method from model.IRaiseable which answers if the car trailer is fully raised.
     * @return true if trailer isn't down
     */
    @Override
    public boolean isFullyRaised() {
        return !trailerIsDown;
    }

    /**
     * Method from model.IRaiseable which raise the trailer.
     */
    @Override
    public void raise() {
        trailerIsDown = false;
    }

    /**
     * Method from model.IRaiseable which lower the trailer
     */
    @Override
    public void lower() {
        trailerIsDown = true;
    }

    /**
     * Method from model.ITransporter which loads storage with car.
     * @param object defines what object to store in storage
     */
    @Override
    public void load(T object) {
        storage.load(object);
    }

    /**
     * Method from model.ITransporter which unloads the latest car stored in the storage
     * @return latest stored car
     */
    @Override
    public T unload() {
        return storage.removeLastStored();
    }
}
