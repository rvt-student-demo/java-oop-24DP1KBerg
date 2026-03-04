package rvt;



public class CD implements packables {

    private String artist;
    private String name;
    private int year;
    private double weight = 0.1;
    
    
    public CD(String artist, String name, int year){
        this.artist = artist;
        this.name = name;
        this.year = year;
    }


    public double weight() {
        return weight;
    }
    
    @Override
    public String toString() {
        return this.artist + ": " + this.name + "(" + this.year + ")";
    }
}
