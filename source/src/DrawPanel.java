import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Used in paintcomponent to draw images from cars.
    private ArrayList<Pair<ICar, BufferedImage>> carImgList = new ArrayList<>();

    private SpeedMeter speedMeter;
    private int prevSize = 0;

    void mapCarImages(ArrayList<ICar> cars) {
        if (cars.size() > prevSize) {
            String imgDir = "pics/";
            String imgFormat = ".jpg";
            try {
                for (int i = prevSize; i < cars.size(); i++) {
                    ICar car = cars.get(i);
                    carImgList.add(new Pair<>(car, ImageIO.read(DrawPanel.class.getResourceAsStream
                            (imgDir + car.getModelName() + imgFormat))));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (cars.size() < prevSize) {
            for (int i = cars.size(); i < prevSize; i++) {
                carImgList.remove(cars.size());
            }
        }
        prevSize = cars.size();
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        this.speedMeter = new SpeedMeter(5, y, carImgList);
        // Print an error message in case file is not found with a try/catch block
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 0;
        for(Pair<ICar, BufferedImage> pair : carImgList){
            g.drawImage(pair.getLast(), (int) pair.getFirst().getPosX(), y, null);
            y += 75;
        }
        speedMeter.paintText(g);
    }
}
