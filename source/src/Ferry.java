public class Ferry implements IMovable, IRaiseable{

    private Storage storage;
    private Boolean rampIsUp;

    public Ferry(int maxStorage){
        this.storage = new Storage(maxStorage);
    }

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

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
