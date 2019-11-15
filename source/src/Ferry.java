public class Ferry implements IMovable, ILoadable, IRaiseable{

    private Storage storage;
    private Boolean rampIsUp;

    public Ferry(int maxStorage){
        this.storage = new Storage(Car.class, maxStorage);
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

    @Override
    public void load(Object object) {
        storage.load(object);
    }

    @Override
    public Object unload() {
        return storage.removeFirstStored();
    }
}
