package model;

public abstract class CarFactory {

    public static ICar createSaab95() {
        return new Saab95();
    }

    public static ICar createVolvo240() {
        return new Volvo240();
    }

    public static ICar createScania() {
        return new Scania();
    }
}
