/**
 * Class for ferry type with the ability to load cars.
 */
public class Ferry implements IMovable, IRaiseable, ITransporter<Car>{


    /**
     * Local storage for car-ferry
     */
    private Storage<Car> storage;


    /**
     * Ramp for ferry (if and only if rampIsUp; cars can enter ferry
     * Uses lower() and raise() to change status and isFullyRaised() to check status.
     */
    private Boolean rampIsUp;
    private double currentSpeed;
    private double posX;
    private double posY;
    private int angle;


    /**
     * Constructor for Ferry.
     * @param maxStorage limit for amount of cars storeable.
     */
    public Ferry(int maxStorage){
        this.storage = new Storage<>(maxStorage);
    }

    @Override
    public void move() {
        posX += Math.cos(Math.toRadians(angle))*currentSpeed;
        posY += Math.sin(Math.toRadians(angle))*currentSpeed;
    }

    @Override
    public void turnLeft() {
        angle = (angle - 90) % 360;
    }

    @Override
    public void turnRight() {
        angle = (angle + 90) % 360;
    }

    @Override
    public boolean isDown() {
        return rampIsUp;
    }

    @Override
    public boolean isFullyRaised() {
        return rampIsUp;
    }

    @Override
    public void raise() {
        rampIsUp = Boolean.TRUE;
    }

    @Override
    public void lower() {
        rampIsUp = Boolean.FALSE;
    }

    @Override
    public void load(Car car) {
        storage.load(car);
    }

    @Override
    public Car unload(Car car) {
        return storage.removeFirstStored();
    }

    public Object unload() {
        return storage.removeFirstStored();
    }
}
