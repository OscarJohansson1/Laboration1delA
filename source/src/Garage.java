public class Garage implements ILoadable {
    private Storage storage;
    private Car[] acceptableCars;

    public Garage(Car[] acceptableCars, int maxSize){
        this.storage = new Storage(Car.class, maxSize);
        this.acceptableCars = acceptableCars;
    }

    @Override
    public void load(Object car) {
        for(Car acceptableCar : acceptableCars){
            if(car.getClass() == acceptableCar.getClass()){
                storage.load(car);
                break;
            }
        }
    }

    @Override
    public Object unload() {
        return storage.removeFirstStored();
    }
}
