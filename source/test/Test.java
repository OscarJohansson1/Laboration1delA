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



        assertTrue("speedFactor with turbo off wrongly returns " + saab95.speedFactor(),
                saab95.speedFactor() == saab95.getEnginePower() * 0.01);
    }

    /**
     * Tests method speedFactor() in Saab95 when variable turboOn is true.
     */
    @org.junit.Test
    public void testSpeedFactorIfTurboOnSaab95() {
        saab95.setTurboOn();

        assertTrue("speedFactor with turbo on wrongly " + "returns " + saab95.speedFactor(),
                saab95.speedFactor() == saab95.getEnginePower() * 0.01 * 1.3);
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
    public void testDecrementSpeedSaab95(){
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
    public void testDecrementSpeedVolvo240(){
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

        assertTrue("Doesn't turn 90 degrees left",
                volvo240.getAngle() == -90);
    }

    /**
     * Tests method turnRight() in Car. Starting-angel is 0.
     */
    @org.junit.Test
    public void testTurnRight() {
        volvo240.turnRight();

        assertTrue("Doesn't turn 90 degrees right",
                volvo240.getAngle() == 90);
    }

    /**
     * Tests method startEngine() in Car. Starting-speed is 0.
     */
    @org.junit.Test
    public void testStartEngine() {
        saab95.startEngine();

        assertTrue("Doesn't start properly",
                saab95.getCurrentSpeed() == 0.1);
    }

    /**
     * Tests method stopEngine() in Car. Starting-speed is 0.1.
     */
    @org.junit.Test
    public void testStopEngine() {
        saab95.setCurrentSpeed(0.1);
        saab95.stopEngine();

        assertTrue("Doesn't stop properly",
                saab95.getCurrentSpeed() == 0);
    }

    /**
     * Tests method getNrDoors() in Car.
     */
    @org.junit.Test
    public void testGetNrDoors() {
        assertTrue("Doesn't return correct amount of doors",
                volvo240.getNrDoors() == 4);
    }

    /**
     * Tests method getColor() and setColor() in Car.
     */
    @org.junit.Test
    public void testColor() {
        volvo240.setColor(Color.blue);
        assertTrue("Doesn't return correct amount of doors",
                volvo240.getColor() == Color.blue);
    }

    /**
     * Tests method getModelNumber() in Car.
     */
    @org.junit.Test
    public void testGetModelNumber() {
        assertTrue("Doesn't return correct amount of doors",
                saab95.getModelName().equals("Saab95"));
    }

    /**
     * Tests method gas() in Car. Specifically tests edge-case when current speed
     * exceeds the engines power of the car
     */
    @org.junit.Test
    public void testGas() {
        saab95.setCurrentSpeed(124);
        saab95.gas(1);

        assertTrue("Gas doesn't increase current speed properly",
                Double.compare(saab95.getCurrentSpeed(), saab95.getEnginePower()) == 0);
    }

    /**
     * Tests method brake() in Car. Specifically tests edge-case when current speed
     * deceeds 0.
     */
    @org.junit.Test
    public void testBrake() {
        saab95.setCurrentSpeed(1);
        saab95.brake(1);

        assertTrue("Gas doesn't increase current speed properly",
                Double.compare(saab95.getCurrentSpeed(), 0) == 0);
    }
}