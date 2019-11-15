import java.util.ArrayDeque;

public class Storage {
    private Class<?> storeableObjectType;
    private int maxSize;
    private ArrayDeque <Object> storedObjects;

    public Storage(Class<?> objectType, int maxSize){
        this.maxSize = maxSize;
        this.storeableObjectType = objectType;
    }

    public void load(Object object){
        if(storeableObjectType.equals(object.getClass())) {
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
            removed = storedObjects.pop();
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
    }

    public Object removeLastStored(){
        Object removed = new Object();
        if(storedObjects.size() > 0){
            removed = storedObjects.removeLast();
        }
        else{
            System.out.println("Cannot remove object as Storage is empty");
        }
        return removed;
    }

    public int size(){
        return storedObjects.size();
    }
}
