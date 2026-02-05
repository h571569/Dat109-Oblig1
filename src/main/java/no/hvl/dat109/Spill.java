package no.hvl.dat109;

/**
 * @Author Elias Frette
 *
 * */

import no.hvl.dat109.interfaces.SpillInterface;

public class Spill implements SpillInterface {
    // private Brett brett;
    private final int antallSpillerer;
    private boolean vunnet = false;

    /**
     * @Param antallSpillerer må være mellom 2 og 4
     * @Throws IllegalArgumentException hvis antallSpillerer er mindre enn 2 eller større enn 4
     * */
    public Spill(final int antallSpillerer) {
        this.antallSpillerer = antallSpillerer;
    }

    public void spill() {

        if (antallSpillerer < 2 || antallSpillerer > 4) {
            throw new IllegalArgumentException();
        }

        final Brikke[] brikker = new Brikke[antallSpillerer];
        for (int x = 0; x < antallSpillerer; x++) {
            brikker[x] = new Brikke(0, x+1);
        }

        while (!vunnet) {
            
            for (int i = 0; i < antallSpillerer && (!vunnet); i++) {
                int sum = Terning.trill();
                if (brikker[i].getPosisjon()+sum < 100) {
                    brikker[i].setPosisjon(brikker[i].getPosisjon()+sum);
                    System.out.println("Brikke " + brikker[i].getBrikkeId()+ " er på rute "+ brikker[i].getPosisjon()+ " og fikk terningkast: " + sum);
                } else if (brikker[i].getPosisjon()+sum == 100) {
                    System.out.println("Brikke: "+ brikker[i].getBrikkeId()+ " Har vunnet!");
                    vunnet = true;
                } else {
                    System.out.println(brikker[i].getBrikkeId()+ " fikk for mye!");
                }
                sum = 0;
            }
        }
    }
}
