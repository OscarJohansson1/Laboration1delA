import org.junit.Before;

public class Test {
    private Saab95 saab95;
    private Volvo240 volvo240;

    @Before
    public void init() {
        saab95 = new Saab95();
        volvo240 = new Volvo240();
    }


    @org.junit.Test
    public void testSpeedFactorIfTurboOffSaab95() {
        saab95.setTurboOff();

        assert saab95.speedFactor() == saab95.getEnginePower() * 0.01 :
                "speedFactor with turbo off wrongly returns " + saab95.speedFactor();
    }

    @org.junit.Test
    public void testSpeedFactorIfTurboOnSaab95() {
        saab95.setTurboOn();

        assert saab95.speedFactor() == saab95.getEnginePower() * 0.01 * 1.3:
                "speedFactor with turbo on wrongly " + "returns " + saab95.speedFactor();
    }


    @org.junit.Test
    public void testIncrementSpeedSaab95() {
        double saabSpeed = saab95.getCurrentSpeed();
        saab95.incrementSpeed(1);

        assert Double.compare(saab95.getCurrentSpeed(), saabSpeed) > 0 :
                "IncrementSpeed didn't increment speed";
    }

    @org.junit.Test
    public void testIncrementSpeedVolvo240() {
        double volvoSpeed = volvo240.getCurrentSpeed();
        volvo240.incrementSpeed(1);

        assert Double.compare(volvo240.getCurrentSpeed(), volvoSpeed) > 0 :
                "IncrementSpeed didn't increment speed";
    }

    @org.junit.Test
    public void testDecrementSpeedSaab95(){
        double speed = saab95.getCurrentSpeed();
        saab95.decrementSpeed(1);

        assert Double.compare(saab95.getCurrentSpeed(), speed) <= 0 :
                "Decrement speed didn't decrement speed properly";
    }

    @org.junit.Test
    public void testDecrementSpeedVolvo240(){
        double speed = volvo240.getCurrentSpeed();
        volvo240.decrementSpeed(1);

        assert Double.compare(volvo240.getCurrentSpeed(), speed) <= 0 :
                "Decrement speed didn't decrement speed properly";
    }
}