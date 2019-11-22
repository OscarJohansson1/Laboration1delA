import org.junit.Before;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * The Test class stores all test-methods.
 */
public class Test {

    /**
     * Car of model Saab95 used in tests.
     */
    private Saab95 saab95;
    /**
     * Car of model Volvo240 used in tests.
     */
    private Volvo240 volvo240;

    /**
     * Creates new default cars before each test to ensure start values.
     */
    @Before
    public void init() {
        saab95 = new Saab95();
        volvo240 = new Volvo240();
    }

    /**
     * Tests method speedFactor() in Saab95 when variable turboOn is false.
     */
    @org.junit.Test
    public void testSpeedFactorIfTurboOffSaab95() {
        saab95.setTurboOff();

        assertEquals("speedFactor with turbo off wrongly returns " + saab95.speedFactor(), saab95.speedFactor(), saab95.getEnginePower() * 0.01, 0.0);
    }

    /**
     * Tests method speedFactor() in Saab95 when variable turboOn is true.
     */
    @org.junit.Test
    public void testSpeedFactorIfTurboOnSaab95() {
        saab95.setTurboOn();

        assertEquals("speedFactor with turbo on wrongly " + "returns " + saab95.speedFactor(), saab95.speedFactor(), saab95.getEnginePower() * 0.01 * 1.3, 0.0);
    }

    /**
     * Tests method incrementSpeed() in Saab95. Starting-speed is 0.
     */
    @org.junit.Test
    public void testIncrementSpeedSaab95() {
        double saabSpeed = saab95.getCurrentSpeed();
        saab95.incrementSpeed(1);

        assertTrue("IncrementSpeed didn't increment speed",
                Double.compare(saab95.getCurrentSpeed(), saabSpeed) > 0);
    }

    /**
     * Tests method incrementSpeed() in Volvo240. Starting-speed is 0.
     */
    @org.junit.Test
    public void testIncrementSpeedVolvo240() {
        double volvoSpeed = volvo240.getCurrentSpeed();
        volvo240.incrementSpeed(1);

        assertTrue("IncrementSpeed didn't increment speed",
                Double.compare(volvo240.getCurrentSpeed(), volvoSpeed) > 0);
    }

    /**
     * Tests method decrementSpeed() in Saab95. Starting-speed is 0.1.
     */
    @org.junit.Test
    public void testDecrementSpeedSaab95() {
        saab95.setCurrentSpeed(0.1);
        double speed = saab95.getCurrentSpeed();
        saab95.decrementSpeed(1);

        assertTrue("Decrement speed didn't decrement speed properly",
                Double.compare(saab95.getCurrentSpeed(), speed) < 0);
    }

    /**
     * Tests method decrementSpeed() in Volvo240. Starting-speed is 0.1.
     */
    @org.junit.Test
    public void testDecrementSpeedVolvo240() {
        volvo240.setCurrentSpeed(0.1);
        double speed = volvo240.getCurrentSpeed();
        volvo240.decrementSpeed(1);

        assertTrue("Decrement speed didn't decrement speed properly",
                Double.compare(volvo240.getCurrentSpeed(), speed) < 0);
    }

    /**
     * Tests method move() in Car. Starting-angel is 0.
     */
    @org.junit.Test
    public void testMove() {
        saab95.setCurrentSpeed(1);
        saab95.move();

        assertTrue("Move doesn´t move properly",
                saab95.getPosX() == 1 && saab95.getPosY() == 0);
    }

    /**
     * Tests method turnLeft() in Car. Starting-angel is 0.
     */
    @org.junit.Test
    public void testTurnLeft() {
        volvo240.turnLeft();

        assertEquals("Doesn't turn 90 degrees left", volvo240.getAngle(), -90);
    }

    /**
     * Tests method turnRight() in Car. Starting-angel is 0.
     */
    @org.junit.Test
    public void testTurnRight() {
        volvo240.turnRight();

        assertEquals("Doesn't turn 90 degrees right", 90, volvo240.getAngle());
    }

    /**
     * Tests method startEngine() in Car. Starting-speed is 0.
     */
    @org.junit.Test
    public void testStartEngine() {
        saab95.startEngine();

        assertEquals("Doesn't start properly", 0.1, saab95.getCurrentSpeed(), 0.0);
    }

    /**
     * Tests method stopEngine() in Car. Starting-speed is 0.1.
     */
    @org.junit.Test
    public void testStopEngine() {
        saab95.setCurrentSpeed(0.1);
        saab95.stopEngine();

        assertEquals("Doesn't stop properly", 0, saab95.getCurrentSpeed(), 0.0);
    }

    /**
     * Tests method getNrDoors() in Car.
     */
    @org.junit.Test
    public void testGetNrDoors() {
        assertEquals("Doesn't return correct amount of doors", 4, volvo240.getNrDoors());
    }

    /**
     * Tests method getColor() and setColor() in Car.
     */
    @org.junit.Test
    public void testColor() {
        volvo240.setColor(Color.blue);

        assertSame("Doesn't return correct amount of doors", volvo240.getColor(), Color.blue);
    }

    /**
     * Tests method getModelNumber() in Car.
     */
    @org.junit.Test
    public void testGetModelNumber() {
        assertEquals("Doesn't return correct amount of doors", "Saab95", saab95.getModelName());
    }

    /**
     * Tests method gas() in Car. Specifically tests edge-case when current speed
     * exceeds the engines power of the car
     */
    @org.junit.Test
    public void testGas() {
        saab95.setCurrentSpeed(124);
        saab95.gas(1);

        assertEquals("Gas doesn't increase current speed properly", 0, Double.compare(saab95.getCurrentSpeed(), saab95.getEnginePower()));
    }

    /**
     * Tests method brake() in Car. Specifically tests edge-case when current speed
     * deceeds 0.
     */
    @org.junit.Test
    public void testBrake() {
        saab95.setCurrentSpeed(1);
        saab95.brake(1);

        assertEquals("Gas doesn't increase current speed properly", 0, Double.compare(saab95.getCurrentSpeed(), 0));
    }

    @org.junit.Test
    public void testFerryLoadUnload(){
        Ferry ferry = new Ferry(2);
        Saab95 coolCar = new Saab95();
        Saab95 unCoolCar = new Saab95();
        ferry.load(coolCar);
        ferry.load(unCoolCar);
        assertEquals("Wrong Car", coolCar, ferry.unload());
        assertEquals("Wrong Car", unCoolCar, ferry.unload());
    }

    @org.junit.Test
    public void testCreatingGarage(){
        Garage<Volvo240> garage = new Garage<>(10);
        //garage.load(saab95);
        garage.load(volvo240);
    }

    @org.junit.Test
    public void testScaniaNoTrailerToRemove(){

        Scania s = new Scania();

        s.removeTrailer();
        assertFalse("No trailer to remove from Scania.", s.getTrailerConnected());

        //assertFalse("Garage is full, when it´s not supposed to", garage.isGarageFull());
    }

    @org.junit.Test
    public void testScaniaRemoveTrailer(){

        Scania s = new Scania();

        s.addTrailer();

        s.removeTrailer();
        assertFalse("Trailer is succesfully removed from Scania.", s.getTrailerConnected());

    }

}