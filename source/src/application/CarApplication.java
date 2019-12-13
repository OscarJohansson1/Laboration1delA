package application;

import model.ICar;
import model.CarModel;
import controller.CarController;
import view.CarView;

import java.util.ArrayList;

public class CarApplication {

    public static void main(String[] args) {

        // The frame that represents this instance View of the MVC pattern
        CarView frame = new CarView("CarSim 1.0");

        CarModel cm = new CarModel(frame.getX());
        ArrayList<ICar> cars = cm.getICarList();

        // Instance of this class
        CarController cc = new CarController(cars, cm);

        // Send the car list to drawPanel so it can map the cars
        frame.setCarsList(cars);

        // Start a new view and send a reference of self
        frame.addObserver(cc);
        cm.addObserver(frame);
    }

}
