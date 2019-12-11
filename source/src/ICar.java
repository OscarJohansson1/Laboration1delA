public interface ICar {

    void gas(double amount);

    void brake(double amount);

    void setTurboOn();

    void setTurboOff();

    void raiseTrailer(int amount);

    void lowerTrailer(int amount);

    void startEngine();

    void stopEngine();

    void move();

    double getPosX();

    double getPosY();

    String getModelName();

    void setPosX(double x);

    void setPosY(double y);

    void turnLeft();

    void turnRight();

    double getCurrentSpeed();

}