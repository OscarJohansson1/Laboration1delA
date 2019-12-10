public class BeerBarrel {

    private double litresOfBeerStored;
    private int sizeInLitres;
    private String brand;

    public BeerBarrel(int sizeInLitres, Boolean filled, String brand){
        this.sizeInLitres = sizeInLitres;
        this.litresOfBeerStored = 0;
        if(filled){
            this.litresOfBeerStored = sizeInLitres;
        }
        this.brand = brand;
    }
}
