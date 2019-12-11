import java.util.ArrayList;

class CreatedCars {

    private static ArrayList<ICar> cars = new ArrayList<>();

    CreatedCars() {
        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95());
        cars.add(CarFactory.createScania());
    }

    static ArrayList<ICar> getICarList() {
        return cars;
    }
}
