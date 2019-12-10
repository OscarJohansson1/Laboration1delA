public interface IObserver {

    void actOnUpdate(ButtonEvents event);

    void actOnUpdate(ButtonEvents event, double amount);
}
