import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Used in paintcomponent to draw images from cars.
    private HashMap<ICar, BufferedImage> carImgHash = new LinkedHashMap<>();
    private SpeedMeter speedMeter;

    void mapCarImages(ArrayList<ICar> cars) {
        String imgDir = "pics/";
        String imgFormat = ".jpg";
        try {
            for (ICar car : cars){
                carImgHash.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream
                        (imgDir+car.getModelName()+imgFormat)));
            }
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        this.speedMeter = new SpeedMeter(5, y);
        // Print an error message in case file is not found with a try/catch block
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 0;
        for(HashMap.Entry<ICar, BufferedImage> entry: carImgHash.entrySet()){
            g.drawImage(entry.getValue(), (int) entry.getKey().getPosX(), y, null);
            y += 100;
        }
        speedMeter.paintText(g);
    }
}
