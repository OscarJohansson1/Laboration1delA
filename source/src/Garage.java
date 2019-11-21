/**
 * The Garage class describes garage where you can store things.
 */
public class Garage<T> implements ITransporter<T> {
    private Storage<T> storage;
/**
 * The Garage class is used to create Garages which can store a certain type of the superclass Car.
 *
 */
public class Garage<T> {

    /**
     * Stores all Car objects for the Garage class
     */
    private Storage storage;

    /**
     * Constructor for class Garage
     */
    public Garage(int maxSize){
        storage = new Storage(maxSize);
    }

    /**
     * Implementation of Interface ILoadable method load.
     */
    @Override
    public void load(T car) {
        storage.load(car);
    }

    /**
     * Implementation of Interface ILoadable method unload.
     */
    public Object unload() {
    @Override
    public T unload() {
        return storage.removeFirstStored();
    }

    public boolean isGarageFull() {
        return storage.isFull();
    }
}
