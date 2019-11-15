import java.util.ArrayList;
import java.util.List;

public class CarTrailer implements IRaiseable, ILoadable {

    private boolean trailerIsDown = true;
    private List<Car> cars = new ArrayList<>();
    private Storage storage;

    public CarTrailer(int maxStorage) {
        this.storage = new Storage(Car.class, maxStorage);
    }//

    public int getAmountOfCars() {
        return cars.size();
    }

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

}
