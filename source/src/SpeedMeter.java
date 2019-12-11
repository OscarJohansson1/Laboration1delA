import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedMeter extends JPanel {

    private ArrayList<ICar> cars = CreatedCars.getICarList();
    private int x;
    private int y;

    SpeedMeter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void paintText(Graphics g) {
        int dy = y - 20 * cars.size();
        for (ICar car : cars) {
            g.setColor(Color.BLACK);
            g.drawString(car.getModelName() + " : " + car.getCurrentSpeed(), x, dy);
            dy += 20;
        }
    }
}
