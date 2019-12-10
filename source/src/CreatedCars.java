import java.util.ArrayList;
import java.util.List;

public class CreatedCars {

    ArrayList<ICar> cars = new ArrayList<>();

    CreatedCars() {
        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95());
        cars.add(CarFactory.createScania());
    }

    public ArrayList<ICar> getICarList() {
        return cars;
    }
}
