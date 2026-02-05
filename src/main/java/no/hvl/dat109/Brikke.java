package no.hvl.dat109;

import no.hvl.dat109.grensefjes.BrikkeFjes;

public class Brikke implements BrikkeFjes {
    private int posisjon;
    private int brikkeId;

    public Brikke(int posisjon, int brikkeId) {
        this.posisjon = posisjon;
        this.brikkeId = brikkeId;
    }
    @Override
    public int getPosisjon() {
        return posisjon;
    }
    @Override
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
