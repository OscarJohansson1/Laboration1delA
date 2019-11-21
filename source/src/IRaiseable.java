/**
 * Interface for classes which can be raised.
 */
public interface IRaiseable {

    boolean isDown();

    boolean isFullyRaised();

    void raise();

    void lower();
}
