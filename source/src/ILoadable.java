public interface ILoadable {

    void load(Object object);

    Object removeAtIndex(int index);

    Object removeFirstStored();

    Object removeLastStored();

}
