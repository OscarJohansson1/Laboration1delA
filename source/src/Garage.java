public class Garage<T> implements ITransporter<T> {
    private Storage<T> storage;

    public Garage(int maxSize){
        storage = new Storage<>(maxSize);
    }

    @Override
    public void load(T car) {
        storage.load(car);
    }

    @Override
    public T unload(T t) {
        return storage.removeFirstStored();
    }


    public boolean isGarageFull() {
        return storage.isFull();
    }
}
