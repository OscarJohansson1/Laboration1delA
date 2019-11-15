import java.util.ArrayList;
import java.util.List;

public class CarTrailer implements IRaiseable, ILoadable {

    private boolean trailerIsDown = true;
    private Storage storage;

    public CarTrailer(int maxStorage) {
        this.storage = new Storage(Car.class, maxStorage);
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
    public void load(Object object) {
        storage.load(object);
    }

    @Override
    public Object unload() {
        return storage.removeLastStored();
    }
}
