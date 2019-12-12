import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class SpeedMeter extends JPanel {

    private HashMap<ICar, BufferedImage> cars;
    private int x;
    private int y;

    SpeedMeter(int x, int y, HashMap<ICar, BufferedImage> cars) {
        this.x = x;
        this.y = y;
        this.cars = cars;
    }

    void paintText(Graphics g) {
        int dy = y - 20 * cars.size();
        for (ICar car : cars.keySet()) {
            g.setColor(Color.BLACK);
            g.drawString(car.getModelName() + " : " + car.getCurrentSpeed(), x, dy);
            dy += 20;
        }
    }
}
