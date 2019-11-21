import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing objects.
 * Intended to be used in other classes with modifications to their ILoadable functions
 */
public class Storage<T> implements ILoadable<T> {

    /**
     * Max size of storage
     * @param maxSize
     */
    private int maxSize;

    /**
     * List with stored objects
     * @param storedObjects
     */
    private List<T> storedObjects = new ArrayList<>();



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
    public void load(T object){
        if(storedObjects.size() < maxSize) {
            storedObjects.add(object);
        }
    }

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

    public boolean isFull() {
        return storedObjects.size() == maxSize;
    }

    public int size(){
        return storedObjects.size();
    }

    /*

    private Class<?> storeableObjectType;
    private int maxSize;
    private ArrayDeque <Object> storedObjects = new ArrayDeque<>();

    public Storage(Class<?> objectType, int maxSize){
        this.maxSize = maxSize;
        this.storeableObjectType = objectType;
    }

    public void load(T object){
        if(storeableObjectType.equals(object.getClass()) ||
                storeableObjectType.equals(object.getClass().getSuperclass())) {
            if(storedObjects.size() < maxSize) {
                storedObjects.push(object);
            }
            else{
                System.out.println("Cannot store more objects.");
            }
        }
        else {
            System.out.println("Cannot store this type of object.");
        }
    }

    public Object removeFirstStored(){
        Object removed = new Object();
        if(storedObjects.size() > 0){
            removed = storedObjects.removeLast();
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
    }

    public Object removeLastStored(){
        Object removed = new Object();
        if(storedObjects.size() > 0){
            removed = storedObjects.removeFirst();
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
    }

    public int size(){
        return storedObjects.size();
    }
     */
}
