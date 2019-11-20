public class Ferry implements IMovable, IRaiseable{

    private Storage storage;
    private Boolean rampIsUp;
    private double currentSpeed;
    private double posX;
    private double posY;
    private int angle;


    public Ferry(int maxStorage){
        this.storage = new Storage(maxStorage);
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

    public void load(Car car) {
        storage.load(car);
    }

    public Object unload() {
        return storage.removeFirstStored();
    }
}
