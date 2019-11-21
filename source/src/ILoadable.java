/**
 * Interface for classes which store objects of type A.
 * @param <A> the type
 */
public interface ILoadable<A> {

    /**
     * Load object of type A and add to list of type A.
     * @param a variable of type A
     */
    void load(A a);

    /**
     * Remove object from specific index of list
     * @param index index of object to remove from list
     * @return removed object (of type A)
     */
    A removeAtIndex(int index);

    /**
     * Remove the object that was loaded first
     * @return the first object loaded (of type A)
     */
    A removeFirstStored();

    /**
     * Remove the object that was loaded last
     * @return the latest object loaded (of type A)
     */
    A removeLastStored();

}
