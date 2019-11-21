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
    public void load(T car) {
        storage.load(car);
    }

    /**
     * Implementation of Interface ILoadable method unload.
     */
    public Object unload() {
        return storage.removeFirstStored();
    }
}
