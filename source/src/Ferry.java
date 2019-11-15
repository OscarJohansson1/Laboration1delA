public class Ferry implements IMovable, ILoadable, IRaiseable{

    private Storage storage;
    private LoadingPlatform loadingPlatform;

    public Ferry(int maxStorage, int loadingAngle){
        this.storage = new Storage(Car.class, maxStorage);
        this.loadingPlatform = new LoadingPlatform(loadingAngle);
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
        return false;
    }

    @Override
    public boolean isFullyRaised() {
        return false;
    }

    @Override
    public void raise() {

    }

    @Override
    public void lower() {

    }

    @Override
    public void load(Car car) {
        storage.load(car);
    }

    @Override
    public Object unload() {
        return storage.removeFirstStored();
    }
}
