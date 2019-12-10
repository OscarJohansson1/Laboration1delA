/**
 * Class for ferry type with the ability to load cars.
 */
public abstract class Ferry implements IMovable, IRaiseable{

    /**
     * Ramp for ferry (if and only  if rampIsUp; cars can enter ferry
     * Uses lower() and raise() to change status and isFullyRaised() to check status.
     */
    private Boolean rampIsUp;

    /**
     * Variable for current speed of Ferry.
     */
    private double currentSpeed;
    /**
     * Variable for x-position of Ferry.
     */
    private double posX;
    /**
     * Variable for y-position of Ferry.
     */
    private double posY;
    /**
     * Variable for current angle Ferry is facing at the moment.
     */
    private int angle;

    public Ferry(){

    }

    /**
     * Method from IMovable which move the Ferry forward.
     */
    @Override
    public void move() {
        posX += Math.cos(Math.toRadians(angle))*currentSpeed;
        posY += Math.sin(Math.toRadians(angle))*currentSpeed;
    }

    /**
     * Method from IMovable which rotates Ferry 90 degrees to the left.
     */
    @Override
    public void turnLeft() {
        angle = (angle - 90) % 360;
    }

    /**
     * Method from IMovable which rotates Ferry 90 degrees to the right.
     */
    @Override
    public void turnRight() {
        angle = (angle + 90) % 360;
    }

    /**
     * Method from IRaiseable which checks if the ramp is down.
     * @return true if the ramp isn't up
     */
    @Override
    public boolean isDown() {
        return !rampIsUp;
    }

    /**
     * Method from IRaisable which checks if the ramp is up.
     * @return true if the ramp is up
     */
    @Override
    public boolean isFullyRaised() {
        return rampIsUp;
    }

    /**
     * Method from IRaisable which raise the ramp.
     */
    @Override
    public void raise() {
        rampIsUp = true;
    }

    /**
     * Method from IRaisable which lower the ramp.
     */
    @Override
    public void lower() {
        rampIsUp = false;
    }

}
