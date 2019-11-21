/**
 * Interface for classes which transport stored objects of type A.
 * @param <A>
 */
public interface ITransporter<A> {

    void load(A a);

    A unload(A a);
}
