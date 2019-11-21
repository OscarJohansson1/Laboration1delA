public class Garage<T> {
    private Storage storage;

    public Garage(int maxSize){
        storage = new Storage(maxSize);
    }

    public void load(T car) {
        storage.load(car);
    }

    public Object unload() {
        return storage.removeFirstStored();
    }
}