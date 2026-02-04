package no.hvl.dat109;

import no.hvl.dat109.grensefjes.TerningFjes;

public class Terning implements TerningFjes {

    public int trill() {
        return(int)(Math.random() * 6) + 1;
    }
}


