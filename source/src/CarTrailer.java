/**
 * The CarTrailer class describes a trailer which store cars.
 */
public class CarTrailer implements IRaiseable, ITransporter<Car> {

    private boolean trailerIsDown = true;
    private Storage<Car> storage;

    public CarTrailer(int maxStorage) {
        this.storage = new Storage<>(maxStorage);
    }

    public int getAmountOfCars() {
        return storage.size();
    }
//
    @Override
    public boolean isDown() {
        return trailerIsDown;
    }

    @Override
    public boolean isFullyRaised() {
        return !trailerIsDown;
    }

    @Override
    public void raise() {
        trailerIsDown = false;
    }

    @Override
    public void lower() {
        trailerIsDown = true;
    }

    @Override
    public void load(Car car) {
        storage.load(car);
    }

    @Override
    public Car unload(Car car) {
        return storage.removeLastStored();
    }
}
