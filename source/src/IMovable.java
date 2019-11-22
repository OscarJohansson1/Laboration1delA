/**
 * Interface for movable objects.
 */

public interface IMovable {
    /**
     * Move object forward if allowed (based on current direction).
     */
    void move();

    /**
     * Turn 90 degrees to the left.
     */
    void turnLeft();

    /**
     * Turn 90 degrees to the right.
     */
    void turnRight();
}
