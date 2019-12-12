import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CarModel implements IObservable {

    private int worldXSize;

    private ArrayList<ICar> cars;

    private ArrayList<IObserver> observers = new ArrayList<>();



    CarModel(ArrayList<ICar> cars, int x) {
        this.cars = cars;
        worldXSize = x;
        // The timer is started with an listener (see below) that executes the statements
        // each step between delays.
        // The delay (ms) corresponds to 20 updates a sec (hz)
        int delay = 50;
        Timer timer = new Timer(delay, new TimerListener());
        timer.start();
    }


    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
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

                // Lets observers know that the state has been changed and they should update accordingly.
                for (IObserver observer : observers) {
                    observer.actOnUpdate(ButtonEvents.UPDATE);
                }
            }
        }
    }

}
