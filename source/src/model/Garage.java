package model;

/**
 * The model.Garage class is used to create Garages which can store a certain type of the superclass model.Car.
 *
 */
public class Garage<T extends Car> implements ITransporter<T> {

    /**
     * Stores all model.Car objects for the model.Garage class
     */
    private Storage<T> storage;

    /**
     * Constructor for class model.Garage
     * @param maxSize max size of the storage
     */
    Garage(int maxSize){
        storage = new Storage<>(maxSize);
    }

    /**
     * Implementation of Interface model.ILoadable method load.
     */
    @Override
    public void load(T car) {
        storage.load(car);
    }

    /**
     * Implementation of Interface model.ILoadable method unload.
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
