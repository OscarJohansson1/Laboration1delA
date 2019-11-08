public class Test {
    Saab95 saab95 = new Saab95();
    Volvo240 volvo240 = new Volvo240();


    @org.junit.Test
    public void testSpeedFactorIfTurboOffSaab95() {
        saab95.setTurboOff();

        assert saab95.speedFactor() == saab95.getEnginePower() * 0.01 : "speedFactor with turbo off wrongly returns "
                + saab95.speedFactor();
    }

    @org.junit.Test
    public void testSpeedFactorIfTurboOnSaab95() {
        saab95.setTurboOn();

        assert saab95.speedFactor() == saab95.getEnginePower() * 0.01 * 1.3: "speedFactor with turbo on wrongly " +
                "returns " + saab95.speedFactor();
    }

    //public void testIncrementSpeedSaab95() {
     //   double prelSpeed = saab95.setCurrentSpeed();
    //}

    @org.junit.Test
    public void testIncrementSpeedSaab95() {
        double saabSpeed = saab95.getCurrentSpeed();
        saab95.incrementSpeed(1);

        assert Double.compare(saab95.getCurrentSpeed(), saabSpeed) > 0 : "IncrementSpeed didn't increment speed";
    }

    @org.junit.Test
    public void testIncrementSpeedVolvo240() {
        double volvoSpeed = volvo240.getCurrentSpeed();
        volvo240.incrementSpeed(1);

        assert Double.compare(volvo240.getCurrentSpeed(), volvoSpeed) > 0 : "IncrementSpeed didn't increment speed";
    }
}
