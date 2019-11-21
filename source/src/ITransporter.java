/**
 * Interface for classes which transport stored objects of type A.
 * @param <A> type of object you want to transport
 */
public interface ITransporter<A> {

    /**
     * Load transporter with object of type A
     * @param a variable of type A
     */
    void load(A a);

    /**
     * Unload object from transporter
     * @return object of type A
     */
    A unload();
}
