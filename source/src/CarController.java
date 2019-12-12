import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
public class CarController implements IObserver {
    // member fields:

    // A list of cars, modify if needed
    private ArrayList<ICar> cars;

    CarController(ArrayList<ICar> cars) {
        this.cars = cars;
    }

    public void actOnUpdate(ButtonEvents event) {
        actOnUpdate(event, 0);
    }

    public void actOnUpdate(ButtonEvents event, double amount) {
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
