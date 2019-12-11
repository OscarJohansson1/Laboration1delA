import java.util.ArrayList;
import java.util.List;

public class CreatedCars {

    static ArrayList<ICar> cars = new ArrayList<>();

    CreatedCars() {
        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95());
        cars.add(CarFactory.createScania());
    }

    public static ArrayList<ICar> getICarList() {
        return cars;
    }
}
