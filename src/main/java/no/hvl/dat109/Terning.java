package no.hvl.dat109;

/**
 * @Author Elias Frette
 * @Autor Edvar Motrøen
 * @Author Jonas glambek
 * */

import no.hvl.dat109.interfaces.TerningInterface;

public class Terning implements TerningInterface {


    /**
     * @Return Ett tilfeldig nummer mellom 1 og 6, som representerer en terningkast.
     * */
    public static int trill() {
        return(int)(Math.random() * 6) + 1;
    }
}


