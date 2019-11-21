/**
 * The Trailer class describes a trailer which can be raised.
 */
public class Trailer implements IRaiseable {

    private boolean trailerIsDown = true;
    private int angle = 0;
    private int maximumAngle;

    Trailer(int maximumAngle) {
        this.maximumAngle = maximumAngle;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public boolean isDown() {
        return trailerIsDown;
    }

    @Override
    public boolean isFullyRaised() {
        return angle == maximumAngle;
    }

    @Override
    public void raise() {
        raise(1);
    }

    public void raise(int angleToRaise) {
        angle += angleToRaise;
        if(angle > maximumAngle) {
            angle = maximumAngle;
            trailerIsDown = false;
        }
    }

    @Override
    public void lower() {
        lower(1);
    }

    public void lower(int angleToLower) {
        angle -= angleToLower;
        if(angle < 0) {
            angle = 0;
            trailerIsDown = true;
        }
    }
}