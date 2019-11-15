public class Ferry implements IMovable{

    private Transporter storage;
    private LoadingPlatform loadingPlatform;

    public Ferry(int maxStorage, int loadingAngle){
        this.storage = new Transporter(Car.class, maxStorage);
        this.loadingPlatform = new LoadingPlatform(Boolean.FALSE, loadingAngle);
    }

    public void enterCar(Car car){
        if(loadingPlatform.isPlatformUp()){
            storage.store(car);
        }
    }

    public Car exitCar(){
        return (Car) storage.removeFirstStored();
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
