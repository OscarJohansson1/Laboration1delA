import java.util.ArrayList;
import java.util.List;

public class CarTrailer implements IRaiseable {

    private boolean trailerIsDown = true;
    private Storage storage;

    public CarTrailer(int maxStorage) {
        this.storage = new Storage(maxStorage);
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

    public void load(Car car) {
        storage.load(car);
    }

    public Car unload() {
        return (Car) storage.removeLastStored();
    }
}
