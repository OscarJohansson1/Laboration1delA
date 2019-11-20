import java.util.ArrayList;
import java.util.List;

public class Storage implements ILoadable {
    private int maxSize;
    private List<Object> storedObjects = new ArrayList<>();

    public Storage(int maxSize){
        this.maxSize = maxSize;
    }

    @Override
    public void load(Object object){
        if(storedObjects.size() < maxSize) {
            storedObjects.add(object);
        }
    }

    @Override
    public Object removeAtIndex(int i){
        Object removed = new Object();
        if(storedObjects.size() > 0){
            removed = storedObjects.remove(i);
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
    }

    @Override
    public Object removeFirstStored(){
        Object removed = new Object();
        if(storedObjects.size() > 0){
            removed = storedObjects.remove(0);
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
    }

    @Override
    public Object removeLastStored(){
        Object removed = new Object();
        if(storedObjects.size() > 0){
            removed = storedObjects.remove(storedObjects.size() - 1);
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
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
