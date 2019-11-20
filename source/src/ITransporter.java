public interface ITransporter<A> {

    void load(A a);

    A unload(A a);
}
