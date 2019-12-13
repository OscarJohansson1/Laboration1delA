package model;

public class BeerBarrel {

    private double litresOfBeerStored;

    public double getLitresOfBeerStored() {
        return litresOfBeerStored;
    }

    public int getSizeInLitres() {
        return sizeInLitres;
    }

    public String getBrand() {
        return brand;
    }

    public void fill(){

    }

    public void tap(){

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
