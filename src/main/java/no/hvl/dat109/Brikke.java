package no.hvl.dat109;

public class Brikke {
    private int posisjon;
    private int brikkeId;

    public Brikke(int posisjon, int brikkeId) {
        this.posisjon = posisjon;
        this.brikkeId = brikkeId;
    }
    public int getPosisjon() {
        return posisjon;
    }
    public void setPosisjon(int posisjon) {
        this.posisjon = posisjon;
    }
    public int getBrikkeId() {
        return brikkeId;
    }
    public void setBrikkeId(int brikkeId) {
        this.brikkeId = brikkeId;
    }
}
