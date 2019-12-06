import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Used in paintcomponent to draw images from cars.
    private HashMap<Car, BufferedImage> carImgHash = new HashMap<>();

    void mapCarImages(ArrayList<Car> cars) {
        String imgDir = "pics/";
        String imgFormat = ".jpg";
        try {
            for (Car car : cars){
                carImgHash.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream
                        (imgDir+car.getClass().getName()+imgFormat)));
            };
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
        // Print an error message in case file is not found with a try/catch block
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(HashMap.Entry<Car, BufferedImage> entry: carImgHash.entrySet()){
            g.drawImage(entry.getValue(), (int) entry.getKey().getPosX(), (int) entry.getKey().getPosY(), null);
        }
    }
}
