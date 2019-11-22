/**
 * The Garage class is used to create Garages which can store a certain type of the superclass Car.
 *
 */
public class Garage<T> implements ITransporter<T> {

    /**
     * Stores all Car objects for the Garage class
     */
    private Storage<T> storage;



    /**
     * Constructor for class Garage
     * @param maxSize max size of the storage
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
    @Override
    public T unload() {
        return storage.removeFirstStored();
    }

    /**
     * Determines if garage is full
     * @return if full: true, else: false
     */
    public boolean isGarageFull() {
        return storage.isFull();
    }
}
