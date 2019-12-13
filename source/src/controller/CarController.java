package controller;

import helperClasses.ButtonEvents;
import model.ICar;
import model.CarModel;
import observers.IObserver;

import java.util.ArrayList;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
public class CarController implements IObserver {
    // member fields:

    // A list of cars, modify if needed
    private ArrayList<ICar> cars;
    private CarModel carModel;

    public CarController(ArrayList<ICar> cars, CarModel carModel) {
        this.cars = cars;
        this.carModel = carModel;
    }

    public void actOnUpdate(ButtonEvents event) {
        actOnUpdate(event, 0);
    }

    public void actOnUpdate(ButtonEvents event, double amount) {
        switch (event) {
            case ADDCAR:
                carModel.addRandomCarToList();
                break;
            case ADDSAAB:
                carModel.addSaab95();
                break;
            case ADDVOLVO:
                carModel.addVolvo240();
                break;
            case ADDSCANIA:
                carModel.addScania();
                break;
            case REMOVECAR:
                carModel.removeCarFromList();
                break;
            default:
                break;
        }
        for (ICar car : cars) {
            switch (event) {
                case GAS:
                    car.gas(amount / 100);
                    break;
                case BRAKE:
                    car.brake(amount / 100);
                    break;
                case TURBOON:
                    car.setTurboOn();
                    break;
                case TURBOOFF:
                    car.setTurboOff();
                    break;
                case LIFTBED:
                    car.raiseTrailer(1);
                    break;
                case LOWERBED:
                    car.lowerTrailer(1);
                    break;
                case STOPCARS:
                    car.stopEngine();
                    break;
                case STARTCARS:
                    car.startEngine();
                    break;

            }
        }
    }
}
