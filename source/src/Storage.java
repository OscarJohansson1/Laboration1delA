import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing objects.
 * Intended, but not limited, to be used in other classes which implements ITransporter functions.
 */
public class Storage<T> implements ILoadable<T> {

    /**
     * Max size of storage
     * maxSize
     */
    private int maxSize;

    /**
     * List with stored objects
     * storedObjects
     */
    private List<T> storedObjects = new ArrayList<>();


    /**
     * Constructor for Storage
     * @param maxSize max size of the storage
     */
    public Storage(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Loads object unless maxSize is reached
     * @param object object of interest,the object which we want to load
     */
    @Override
    public boolean load(T object){
        boolean loadSuccessful = Boolean.FALSE;
        if(storedObjects.size() < maxSize) {
            storedObjects.add(object);
            loadSuccessful = Boolean.TRUE;
        }
        return loadSuccessful;
    }

    /**
     * Removes the object with index 'i'.
     * @param i index of object which will be removed
     */
    @Override
    public T removeAtIndex(int i){
        if(storedObjects.size() > 0){
            return storedObjects.remove(i);
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return null;
    }
    /**
     * Removes the object which was stored first. In other words the object from the "top" of the list.
     */
    @Override
    public T removeFirstStored(){
        if(storedObjects.size() > 0){
            return storedObjects.remove(0);
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return null;
    }

    /**
     * Removes the object which was stored last. In other words the object from the "bottom" of the list.
     */
    @Override
    public T removeLastStored(){
        if(storedObjects.size() > 0){
            return storedObjects.remove(storedObjects.size() - 1);
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return null;
    }

    /**
     * Checks if the storage is full.
     * @return if full: true, else: false
     */
    public boolean isFull() {
        return storedObjects.size() == maxSize;
    }


    /**
     * Determines the size of the list of all stored objects
     * @return size of list of stored items
     */
    public int size(){
        return storedObjects.size();
    }

}
