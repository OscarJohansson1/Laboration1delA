import java.awt.*;

public class MercedesBenzActros extends Car implements ILoadable{

    private boolean hasCarTrailerConnected = false;
    private CarTrailer carTrailer = new CarTrailer(10);

    MercedesBenzActros() {
        super(2, 150, Color.magenta, "Mercedes-Benz Actros");
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

    @Override
    public void load(Object object) {
        if (this != object) {
            carTrailer.load(object);
        }
    }

    @Override
    public Object unload() {
        if (getCurrentSpeed() == 0) {
            return carTrailer.unload();
        }
        return null;
    }





}
