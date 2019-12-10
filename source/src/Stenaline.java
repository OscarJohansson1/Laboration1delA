public class Stenaline extends Ferry {

    private Deck deck = new Deck();

    public Stenaline(){
        deck.addStorage(new Storage<Car>(50));
        deck.addStorage(new Storage<BeerBarrel>(1000));
    }

    void loadBeerBarrel(BeerBarrel beerBarrel){
        deck.getLastStorage().load(beerBarrel);
    }

    BeerBarrel unloadBeerBarrel(){
        return (BeerBarrel) deck.getLastStorage().removeLastStored();
    }

    Car unload(){
        return (Car) deck.getFirstStorage().removeFirstStored();
    }

    void loadCar(Car car){
        deck.getFirstStorage().load(car);
    }

}
