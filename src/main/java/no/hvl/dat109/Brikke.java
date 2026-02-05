package no.hvl.dat109;

/**
 * @Author Elias Frette
 * @Author Edvar Motrøen
 * @Author Jonas glambek
 * */

import no.hvl.dat109.interfaces.BrikkeInterface;

public class Brikke implements BrikkeInterface {
    private int posisjon;
    private int brikkeId;

    /**
     * @Param Posisjonen brikken starter på, og brikkeId som er en unik id for hver brikke
     * */
    public Brikke(int posisjon, int brikkeId) {
        this.posisjon = posisjon;
        this.brikkeId = brikkeId;
    }
    /**
     * @Return Posisjonen til brikken
     * */
    public int getPosisjon() {
        return posisjon;
    }

    public void setPosisjon(int posisjon) {
        this.posisjon = posisjon;
    }
    /**
     * @Return BrikkeId som er en unik id for hver brikke
     * */
    public int getBrikkeId() {
        return brikkeId;
    }
    public void setBrikkeId(final int brikkeId) {
        this.brikkeId = brikkeId;
    }
}
