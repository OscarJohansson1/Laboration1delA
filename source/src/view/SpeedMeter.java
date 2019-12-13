package view;

import model.ICar;
import helperClasses.Pair;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class SpeedMeter extends JPanel {

    private ArrayList<Pair<ICar, BufferedImage>> cars;
    private int x;
    private int y;

    SpeedMeter(int x, int y, ArrayList<Pair<ICar, BufferedImage>> cars) {
        this.x = x;
        this.y = y;
        this.cars = cars;
    }

    void paintText(Graphics g) {
        int dy = y - 20 * cars.size();
        for (Pair<ICar, BufferedImage> pair : cars) {
            ICar car = pair.getFirst();
            g.setColor(Color.BLACK);
            g.drawString(car.getModelName() + " : " + car.getCurrentSpeed(), x, dy);
            dy += 20;
        }
    }
}
