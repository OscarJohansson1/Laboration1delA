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

    @org.junit.Test
    public void testDecrementSpeedVolvo240(){
        double speed = saab95.getCurrentSpeed();
        saab95.decrementSpeed(1);
        assert saab95.getCurrentSpeed() == saab95.getCurrentSpeed() - saab95.speedFactor() * 1;
    }
}