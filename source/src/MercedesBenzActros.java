import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * The MercedesBenzActros class describes a car-transporter of the type Mercedes-Benz Actros.
 */
public class MercedesBenzActros extends Car implements ITransporter<Car>{

    private boolean hasCarTrailerConnected = false;
    private CarTrailer carTrailer = new CarTrailer(10);
    private List<Car> cars = new ArrayList<>();

    MercedesBenzActros() {
        super(2, 150, Color.magenta, "Mercedes-Benz Actros");
    }

    @Override
    public void move() {
        super.move();
        for (Car c : cars) {
            c.setPosX(getPosX());
            c.setPosY(getPosY());
        }
    }

    @Override
    public double speedFactor() {
        if (hasCarTrailerConnected) {
            return getEnginePower() * 0.01 * 0.5;
        }
        return getEnginePower() * 0.01;
    }

    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    @Override
    public void incrementSpeed(double amount) {
        if (carTrailer != null && !carTrailer.isDown()) {
            setCurrentSpeed(getCurrentSpeed());
        } else {
            setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
        }
    }

    public void addTrailer(int maxSize) {
        carTrailer = new CarTrailer(maxSize);
        hasCarTrailerConnected = true;
    }

    public void removeTrailer() {
        carTrailer = null;
        hasCarTrailerConnected = false;
    }


    public void load(Car object) {
        double xDifference = object.getPosX() - getPosX();
        double yDifference = object.getPosY() - getPosY();
        if (xDifference < 10 && yDifference < 10) {
            if (this != object && getCurrentSpeed() == 0) {
                carTrailer.load(object);
            }
        }
    }

    @Override
    public Car unload() {
        if (getCurrentSpeed() == 0) {
            return carTrailer.unload();
        }
        return null;
    }






}
