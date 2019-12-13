package model;

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
     * Variable for current speed of model.Ferry.
     */
    private double currentSpeed;
    /**
     * Variable for x-position of model.Ferry.
     */
    private double posX;
    /**
     * Variable for y-position of model.Ferry.
     */
    private double posY;
    /**
     * Variable for current angle model.Ferry is facing at the moment.
     */
    private int angle;

    public Ferry(){

    }

    /**
     * Method from model.IMovable which move the model.Ferry forward.
     */
    @Override
    public void move() {
        posX += Math.cos(Math.toRadians(angle))*currentSpeed;
        posY += Math.sin(Math.toRadians(angle))*currentSpeed;
    }

    /**
     * Method from model.IMovable which rotates model.Ferry 90 degrees to the left.
     */
    @Override
    public void turnLeft() {
        angle = (angle - 90) % 360;
    }

    /**
     * Method from model.IMovable which rotates model.Ferry 90 degrees to the right.
     */
    @Override
    public void turnRight() {
        angle = (angle + 90) % 360;
    }

    /**
     * Method from model.IRaiseable which checks if the ramp is down.
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
