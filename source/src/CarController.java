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
public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
            '
    // Hashmap with cars connected to images
    HashMap<Car, String> carPicHash = new HashMap<>();

    public static void main(String[] args) {

        String imgDir = "pics/";

        // Instance of this class
        CarController cc = new CarController();

        // Crate cars
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();

        // Configure cars
        volvo.setPosY(100);
        saab.setPosY(260);
        scania.setPosY(420);
        scania.addTrailer();

        // Add cars to car controller
        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania);


        cc.carPicHash.put(volvo, imgDir+"Volvo240.jpg");
        cc.carPicHash.put(saab, imgDir+"Saab95.jpg");
        cc.carPicHash.put(scania, imgDir+"Scania.jpg");

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : carPicHash.keySet()){
                car.move();
                int x = (int) Math.round(car.getPosX());
                int y = (int) Math.round(car.getPosY());
                if (x > frame.drawPanel.getWidth() - 100 || x < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                car.setPosX(x);
                car.setPosY(y);
                frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    // Calls the break method for each car once
    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raiseTrailer(1);
            }
        }
    }

    void lowerBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerTrailer(1);
            }
        }
    }

    void startCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopCars(){
        for (Car car : cars) {
            car.stopEngine();
        }
    }
}
