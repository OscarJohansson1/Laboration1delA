package model;

import helperClasses.ButtonEvents;
import observers.IObservable;
import observers.IObserver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class CarModel implements IObservable {

    private int worldXSize;
    private ArrayList<ICar> cars = new ArrayList<>();
    private ArrayList<IObserver> observers = new ArrayList<>();
    private Random rand = new Random();

    public CarModel(int x) {

        addCarsToList();

        worldXSize = x;
        // The timer is started with an listener (see below) that executes the statements
        // each step between delays.
        // The delay (ms) corresponds to 20 updates a sec (hz)
        int delay = 50;
        Timer timer = new Timer(delay, new TimerListener());
        timer.start();
    }

    private void addCarsToList() {
        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95());
        cars.add(CarFactory.createScania());
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public ArrayList<ICar> getICarList() {
        return cars;
    }

    public void removeCarFromList() {
        if (cars.size() > 0) {
            cars.remove(cars.size() - 1);
        }
    }

    public void addSaab95() {
        if (cars.size() < 10) {
            cars.add(CarFactory.createSaab95());
        }
    }
    public void addVolvo240() {
        if (cars.size() < 10) {
            cars.add(CarFactory.createVolvo240());
        }
    }
    public void addScania() {
        if (cars.size() < 10) {
            cars.add(CarFactory.createScania());
        }
    }

    public void addRandomCarToList() {
        if (cars.size() < 10)
            switch (rand.nextInt(3)) {
                case 0:
                    cars.add(CarFactory.createSaab95());
                    break;
                case 1:
                    cars.add(CarFactory.createVolvo240());
                    break;
                case 2:
                    cars.add(CarFactory.createScania());
                    break;
            }
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
                // Could get imgWidth the same way as worldXSize if necessary
                int imgWidth = 100;
                if (x > worldXSize - imgWidth || x < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }

                // Set Positions for cars
                car.setPosY(y);
                car.setPosX(x);

            }
            // Lets observers know that the state has been changed and they should update accordingly.
            for (IObserver observer : observers) {
                observer.actOnUpdate(ButtonEvents.UPDATE);
            }
        }
    }

}
