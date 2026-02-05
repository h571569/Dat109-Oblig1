package no.hvl.dat109;

import java.util.Scanner;

public class Spill {
    // private Brett brett;
    private final int antallSpillerer;
    private boolean vunnet = false;

    public Spill(final int antallSpillerer) {
        this.antallSpillerer = antallSpillerer;
    }

    public void spill() {

        if (antallSpillerer < 2 || antallSpillerer > 4) {
            throw new IllegalArgumentException();
        }

        final Brikke[] brikker = new Brikke[antallSpillerer];
        for (int x = 0; x < antallSpillerer; x++) {
            brikker[x] = new Brikke(0, x + 1);
        }

        Scanner scanner = new Scanner(System.in); 

        while (!vunnet) {
            for (int i = 0; i < antallSpillerer && !vunnet; i++) {

                System.out.println("Brikke nr: " + brikker[i].getBrikkeId()
                        + " sin tur. Trykk Enter for å fortsette..");
                scanner.nextLine(); 

                int sum = Terning.trill();

                if (brikker[i].getPosisjon() + sum < 100) {
                    brikker[i].setPosisjon(brikker[i].getPosisjon() + sum);
                    System.out.println(brikker[i].getBrikkeId() + " er på rute "
                            + brikker[i].getPosisjon() + " og fikk terningkast: " + sum);

                } else if (brikker[i].getPosisjon() + sum == 100) {
                    System.out.println("Brikke: " + brikker[i].getBrikkeId() + " Har vunnet!");
                    vunnet = true;

                } else {
                    System.out.println(brikker[i].getBrikkeId() + " fikk for mye!");
                }
            }
        }

        scanner.close(); 
    }
}