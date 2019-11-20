import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing objects.
 * Intended to be used in other classes with modifications to their ILoadable functions
 */

public class Storage implements ILoadable {
    /**
     * Max size of storage
     * @param maxSize
     */
    private int maxSize;

    /**
     * List with stored objects
     * @param storedObjects
     */
    private List<Object> storedObjects = new ArrayList<>();

    /**
     * Constructor with maxsize
     * @param maxSize
     */
    public Storage(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Loads object unless maxSize is reached
     * @param object
     */
    @Override
    public void load(Object object) {
        if (storedObjects.size() < maxSize) {
            storedObjects.add(object);
        }
    }

    @Override
    public Object removeAtIndex(int i) {
        Object removed = new Object();
        if (storedObjects.size() > 0) {
            removed = storedObjects.remove(i);
        } else {
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
    }

    @Override
    public Object removeFirstStored() {
        Object removed = new Object();
        if (storedObjects.size() > 0) {
            removed = storedObjects.remove(0);
        } else {
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
    }

    @Override
    public Object removeLastStored() {
        Object removed = new Object();
        if (storedObjects.size() > 0) {
            removed = storedObjects.remove(storedObjects.size() - 1);
        } else {
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
    }

    public int size() {
        return storedObjects.size();
    }
}