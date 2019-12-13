package model;

/**
 * The model.Trailer class describes a trailer which can be raised.
 */
public class Trailer implements IRaiseable {

    /**
     * Boolean for determining whether the trailer is up or down
     */
    private boolean trailerIsDown = true;
    /**
     * Determines the angle of the trailer
     */
    private int angle = 0;

    /**
     * Determines the maximum angle trailer is capable of.
     */
    private int maximumAngle;

    /**
     * Constructor for the model.Trailer class.
     * @param maximumAngle maximum angle of the trailer
     */
    Trailer(int maximumAngle) { this.maximumAngle = maximumAngle; }

    /**
     * Getter for the angle variable.
     * @return angle current angle of trailer
     */
    int getAngle() {
        return angle;
    }

    /**
     * Determines the maximum angle trailer is capable of.
     */
    @Override
    public boolean isDown() {
        return trailerIsDown;
    }

    /**
     * Determines if the trailer is fully raised
     */
    @Override
    public boolean isFullyRaised() {
        return angle == maximumAngle;
    }

    /**
     * Raises the trailer by '1' degree, meant for when you do not enter by what amount you want to raise. Can be repeated to use as raise(int amount)
     */
    @Override
    public void raise() {
        raise(1);
    }

    /**
     * Raises the trailer by an int value. If the resulting angle is bigger than the maximum angle it is set to maximumAngle.
     * @param angleToRaise increase of current angle in degrees
     */
    void raise(int angleToRaise) {
        angle += angleToRaise;
        if(angle > maximumAngle) {
            angle = maximumAngle;
        }
        trailerIsDown = false;
    }

    /**
     * Lowers the trailer by '1' degree, meant for when you do not enter by what amount you want to lower. Can be repeated to use as lower(int amount)
     */
    @Override
    public void lower() {
        lower(1);
    }

    /**
     * Lowers the trailer by an int value. If the resulting angle is smaller than the minimum angle it is set to 0.
     * @param angleToLower decrease of current angle in degrees
     */
    void lower(int angleToLower) {
        angle -= angleToLower;
        if(angle <= 0) {
            angle = 0;
            trailerIsDown = true;
        }

    }
}