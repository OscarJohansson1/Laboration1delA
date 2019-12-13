package model;

/**
 * Interface for classes which can be raised.
 */
public interface IRaiseable {

    /**
     * Method which returns if the raiseable part is down.
     * @return true if raiseable part is down
     */
    boolean isDown();

    /**
     * Method which returns if the raiseable part is fully raised.
     * @return true if the raiseable part is fully raised
     */
    boolean isFullyRaised();

    /**
     * Method which raise the raiseable part.
     */
    void raise();

    /**
     * Method which lower the raiseable part.
     */
    void lower();
}
