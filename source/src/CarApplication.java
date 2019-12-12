import java.util.ArrayList;

public class CarApplication {

    public static void main(String[] args) {

        CreatedCars carWorld = new CreatedCars();
        ArrayList<ICar> cars = carWorld.getICarList();

        // Instance of this class
        CarController cc = new CarController(cars);

        // The frame that represents this instance View of the MVC pattern
        CarView frame = new CarView("CarSim 1.0");
        CarModel cm = new CarModel(cars, frame.getX());

        // Start a new view and send a reference of self
        frame.addObserver(cc);
        cm.addObserver(frame);

        // Send the car list to drawPanel so it can map the cars
        frame.addListWithCarsToDrawPanel(cars);
    }

}
