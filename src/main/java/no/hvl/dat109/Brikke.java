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
     * @Param Posisjonen brikken starter på
     * @Param BrikkeId som er en unik id for hver brikke
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

    /**
     * @Param Posisjonen til brikken
     * */
    public void setPosisjon(int posisjon) {
        this.posisjon = posisjon;
    }
    /**
     * @Return BrikkeId som er en unik id for hver brikke
     * */
    public int getBrikkeId() {
        return brikkeId;
    }
    /**
     * @Param BrikkeId som er en unik id for hver brikke
     * */
    public void setBrikkeId(final int brikkeId) {
        this.brikkeId = brikkeId;
    }
}
