public class BeerBarrel {

    private double litresOfBeerStored;

    public double getLitresOfBeerStored() {
        return litresOfBeerStored;
    }

    public void setLitresOfBeerStored(double litresOfBeerStored) {
        this.litresOfBeerStored = litresOfBeerStored;
    }

    public int getSizeInLitres() {
        return sizeInLitres;
    }

    public void setSizeInLitres(int sizeInLitres) {
        this.sizeInLitres = sizeInLitres;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


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
