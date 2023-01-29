package tds;

public class Localisation {
    private int imbrication;
    private int decalage;


    public Localisation(int decalage, int imbrication) {
        this.imbrication = imbrication;
        this.decalage = decalage;
    }

    public Localisation() {
        this.decalage = 0;
        this.imbrication = 0;
    }

    public int numImbrication() {
        return imbrication;
    }

    public int numDecalage() {

        return decalage;
    }


    public void InstancierImbrication(int val){

        this.imbrication = val;
    }

    public void InstancierDecalage(int val){
        this.decalage = val;
    }
}