public class CarApplication {

    public static void main(String[] args) {

        // Instance of this class
        CarController cc = new CarController();
        CreatedCars carWorld = new CreatedCars();

        cc.cars = CreatedCars.getICarList();


        // Start a new view and send a reference of self
        cc.frame.addObserver(cc);

        // Send the car list to drawPanel so it can map the cars
        cc.frame.drawPanel.mapCarImages(cc.cars);
    }

}
