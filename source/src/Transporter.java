import java.util.ArrayDeque;

public abstract class Transporter {
    private Object storeableObjectType;
    private ArrayDeque storedObjects;
    private int maxSize;

    public Transporter(Object objectType, int maxSize){
        this.maxSize = maxSize;
        this.storeableObjectType = objectType;
    }

    public void store(Object object){
        if(storeableObjectType.getClass().equals(object.getClass())) {
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
        Object removed;
        if(storedObjects.size() > 0){
            removed = storedObjects.removeFirst();
        }
        else{
            System.out.println("Cannot remove object as transporter is empty");
        }
        return removed;
    }

    public Object removeLastStored(){
        Object removed;
        if(storedObjects.size() > 0){
            removed = storedObjects.removeLast();
        }
        else{
            System.out.println("Cannot remove object as transporter is empty");
        }
        return removed;
    }
}
