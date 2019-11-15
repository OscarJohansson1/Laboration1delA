import java.awt.*;

public class MercedesBenzActros extends Car{

    private boolean hasCarTrailerConnected = false;
    private CarTrailer carTrailer = new CarTrailer();

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

    @Override
    void load(){



    }





}
