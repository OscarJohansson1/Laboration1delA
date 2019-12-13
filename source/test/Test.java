
import model.*;
import org.junit.Before;
import org.junit.Ignore;

import java.awt.*;
import static org.junit.Assert.*;

/**
 * The Test class stores all test-methods.
 */
@Ignore
public class Test {

    /**
     * model.Car of model model.Saab95 used in tests.
     */
    private Saab95 saab95;
    /**
     * model.Car of model model.Volvo240 used in tests.
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
     * Tests method speedFactor() in model.Saab95 when variable turboOn is false.
     */
    @org.junit.Test
    public void testSpeedFactorIfTurboOffSaab95() {
        saab95.setTurboOff();

        assertEquals("speedFactor with turbo off wrongly returns " + saab95.speedFactor(), saab95.speedFactor(), saab95.getEnginePower() * 0.01, 0.0);
    }

    /**
     * Tests method speedFactor() in model.Saab95 when variable turboOn is true.
     */
    @org.junit.Test
    public void testSpeedFactorIfTurboOnSaab95() {
        saab95.setTurboOn();

        assertEquals("speedFactor with turbo on wrongly " + "returns " + saab95.speedFactor(), saab95.speedFactor(), saab95.getEnginePower() * 0.01 * 1.3, 0.0);
    }

    /**
     * Tests method incrementSpeed() in model.Saab95. Starting-speed is 0.
     */
    @org.junit.Test
    public void testIncrementSpeedSaab95() {
        double saabSpeed = saab95.getCurrentSpeed();
        saab95.incrementSpeed(1);

        assertTrue("IncrementSpeed didn't increment speed",
                Double.compare(saab95.getCurrentSpeed(), saabSpeed) > 0);
    }

    /**
     * Tests method incrementSpeed() in model.Volvo240. Starting-speed is 0.
     */
    @org.junit.Test
    public void testIncrementSpeedVolvo240() {
        double volvoSpeed = volvo240.getCurrentSpeed();
        volvo240.incrementSpeed(1);

        assertTrue("IncrementSpeed didn't increment speed",
                Double.compare(volvo240.getCurrentSpeed(), volvoSpeed) > 0);
    }

    /**
     * Tests method decrementSpeed() in model.Saab95. Starting-speed is 0.1.
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
     * Tests method decrementSpeed() in model.Volvo240. Starting-speed is 0.1.
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
     * Tests method move() in model.Car. Starting-angel is 0.
     */
    @org.junit.Test
    public void testMove() {
        saab95.setCurrentSpeed(1);
        saab95.move();

        assertTrue("Move doesn´t move properly",
                saab95.getPosX() == 1 && saab95.getPosY() == 0);
    }

    /**
     * Tests method turnLeft() in model.Car. Starting-angel is 0.
     */
    @org.junit.Test
    public void testTurnLeft() {
        volvo240.turnLeft();

        assertEquals("Doesn't turn 90 degrees left", volvo240.getAngle(), -90);
    }

    /**
     * Tests method turnRight() in model.Car. Starting-angel is 0.
     */
    @org.junit.Test
    public void testTurnRight() {
        volvo240.turnRight();

        assertEquals("Doesn't turn 90 degrees right", 90, volvo240.getAngle());
    }

    /**
     * Tests method startEngine() in model.Car. Starting-speed is 0.
     */
    @org.junit.Test
    public void testStartEngine() {
        saab95.startEngine();

        assertEquals("Doesn't start properly", 0.1, saab95.getCurrentSpeed(), 0.0);
    }

    /**
     * Tests method stopEngine() in model.Car. Starting-speed is 0.1.
     */
    @org.junit.Test
    public void testStopEngine() {
        saab95.setCurrentSpeed(0.1);
        saab95.stopEngine();

        assertEquals("Doesn't stop properly", 0, saab95.getCurrentSpeed(), 0.0);
    }

    /**
     * Tests method getNrDoors() in model.Car.
     */
    @org.junit.Test
    public void testGetNrDoors() {
        assertEquals("Doesn't return correct amount of doors", 4, volvo240.getNrDoors());
    }

    /**
     * Tests method getColor() and setColor() in model.Car.
     */
    @org.junit.Test
    public void testColor() {
        volvo240.setColor(Color.blue);

        assertSame("Doesn't return correct amount of doors", volvo240.getColor(), Color.blue);
    }

    /**
     * Tests method getModelNumber() in model.Car.
     */
    @org.junit.Test
    public void testGetModelNumber() {
        assertEquals("Doesn't return correct amount of doors", "model.Saab95", saab95.getModelName());
    }

    /**
     * Tests method gas() in model.Car. Specifically tests edge-case when current speed
     * exceeds the engines power of the car
     */
    @org.junit.Test
    public void testGas() {
        saab95.setCurrentSpeed(124);
        saab95.gas(1);

        assertEquals("Gas doesn't increase current speed properly", 0, Double.compare(saab95.getCurrentSpeed(), saab95.getEnginePower()));
    }

    /**
     * Tests method brake() in model.Car. Specifically tests edge-case when current speed
     * deceeds 0.
     */
    @org.junit.Test
    public void testBrake() {
        saab95.setCurrentSpeed(1);
        saab95.brake(1);

        assertEquals("Gas doesn't increase current speed properly", 0, Double.compare(saab95.getCurrentSpeed(), 0));
    }

    /**
     * Test Loading and unloading of ferry with cars.
     */
    @org.junit.Test
    public void testFerryLoadUnload(){
        Stenaline ferry = new Stenaline();
        Saab95 coolCar = new Saab95();
        Saab95 unCoolCar = new Saab95();
        ferry.loadCar(coolCar);
        ferry.loadCar(unCoolCar);
        assertEquals("Wrong model.Car", coolCar, ferry.unloadCar());
        assertEquals("Wrong model.Car", unCoolCar, ferry.unloadCar());
    }

    /**
     * Test Loading and unloading of garage with cars.
     */
    @org.junit.Test
    public void testGarage(){
        Garage<Volvo240> garage = new Garage<>(10);
        garage.load(volvo240);
        assertEquals("model.Car not properly unload ",volvo240, garage.unload());
    }

    /**
     * Test for loading and unloading car transport
     */
    @org.junit.Test
    public void testCarTransport(){
        MercedesBenzActros carTransport = new MercedesBenzActros();
        carTransport.load(saab95);
        carTransport.load(volvo240);
        assertEquals("Wrong car unloaded", carTransport.unload(), volvo240);
        assertEquals("Wrong car unloaded", carTransport.unload(), saab95);
        carTransport.load(saab95);
        carTransport.setCurrentSpeed(1337);
        assertNull("model.Car cannot be unloaded when transporter is moving!", carTransport.unload());
    }

    /**
     * Test for properly loading trailer to scania
     */
    @org.junit.Test
    public void testScaniaNoTrailerToRemove() {

        Scania s = new Scania();

        s.removeTrailer();
        assertFalse("No trailer to remove from model.Scania.", s.getTrailerConnected());
    }

    /**
     * Test for loading and unloading storage with class
     */
    @org.junit.Test
    public void testStorage(){
        Storage<Car> storage = new Storage<>(3);
        storage.load(saab95);
        storage.load(volvo240);
        storage.load(volvo240);
        assertFalse("model.Car was loaded when storage was full!!", storage.load(saab95));
        assertEquals("Wrong car unloaded", storage.removeAtIndex(1), volvo240);
        assertEquals("Wrong car unloaded", storage.removeFirstStored(), saab95);
        storage.load(saab95);
        assertEquals("Wrong car unloaded", storage.removeLastStored(), saab95);
    }

    /**
     * Test if the trailer is down after it has been raised and lowered 'below' minimum.
     */
    @org.junit.Test
    public void testTrailerIsDown(){
        Trailer trailer = new Trailer(10);

        trailer.raise();
        trailer.lower();
        trailer.lower(2);

        assertEquals("Angel is suppose to be 0, but is" + trailer.getAngle(), 0, trailer.getAngle());
        assertTrue("model.Trailer isn't down, when supposed to be down", trailer.isDown());
    }

    /**
     * Test if the trailer is fully raised after it has been raised 'above' maximum.
     */
    @org.junit.Test
    public void testTrailerIsFullyRaised(){

        Trailer trailer = new Trailer(10);
        trailer.raise(15);


        assertTrue("model.Trailer isn't fully raised when supposed to", trailer.isFullyRaised());

    }

    @org.junit.Test
    public void testScaniaRemoveTrailer(){

        Scania s = new Scania();
        s.addTrailer();
        s.removeTrailer();

        assertFalse("model.Trailer is succesfully removed from model.Scania.", s.getTrailerConnected());    }

    /**
     * Test if the trailer changes correctly when raised is called
     */
    @org.junit.Test
    public void testTrailerGetAngle(){
        Trailer trailer = new Trailer(10);
        trailer.raise(5);
        assertEquals("Wrong angle after raise is called",5, trailer.getAngle());
    }

    @org.junit.Test
    public void beerTesting(){
        Stenaline stenaline = new Stenaline();

        String prippsBrand = "Pripps 7.2% Extra Stark";
        BeerBarrel starkPrippsTunna = new BeerBarrel(100, true, prippsBrand);

        stenaline.loadBeerBarrel(starkPrippsTunna);
        assertEquals(stenaline.unloadBeerBarrel().getBrand(), prippsBrand);
    }
}
