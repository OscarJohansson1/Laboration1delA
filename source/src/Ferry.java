public class Ferry implements IMovable{

    Transporter storage;
    LoadingPlatform loadingPlatform;
    Car car;

    public Ferry(int maxStorage, int loadingAngle){
        this.storage = new Transporter(Car.class, maxStorage);
        this.loadingPlatform = new LoadingPlatform(Boolean.FALSE, loadingAngle);
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
}
