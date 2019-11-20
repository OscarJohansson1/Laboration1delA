public interface ILoadable<A> {

    void load(A object);

    A removeAtIndex(int index);

    A removeFirstStored();

    A removeLastStored();

}
