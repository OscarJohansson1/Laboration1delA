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

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    // A list of cars, modify if needed
    ArrayList<ICar> cars;

    public static void main(String[] args) {

        // Instance of this class
        CarController cc = new CarController();
        CreatedCars carWorld = new CreatedCars();

        cc.cars = carWorld.getICarList();


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");

        cc.frame.addObserver(cc);

        // Send the car list to drawPanel so it can map the cars
        cc.frame.drawPanel.mapCarImages(cc.cars);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (ICar car : cars){
                car.move();
                double x = car.getPosX();
                double y = car.getPosY();
                if (x > frame.drawPanel.getWidth() - 100 || x < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }

                // Set Positions for cars
                car.setPosY(y);
                car.setPosX(x);

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
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
