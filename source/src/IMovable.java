/**
 * Interface for movable objects.
 */

public interface IMovable {
    /**
     * Makes the car move forward (based on current direction).
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
